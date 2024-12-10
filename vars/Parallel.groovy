def call() {
    stage('Launch and AMI Creation') {
        parallel {
            stage('Launch Instance') {
                steps {
                    script {
                        sh '''
                            aws ec2 run-instances --region ap-south-1 --image-id ami-053b12d3152c0cc71 \
                                --instance-type t2.micro \
                                --key-name jenkins  \
                                --security-group-ids sg-072642f94d7118f38 \
                                --subnet-id subnet-0c7dc48384c529638 > instance_info.json
                            
                            INSTANCE_ID=$(jq -r '.Instances[0].InstanceId' instance_info.json)
                            echo $INSTANCE_ID > instance_id.txt
                        '''
                    }
                }
            }

            stage('Timeout') {
                steps {
                    script {
                        sleep(30)
                    }
                }
            }

            stage('AMI Creation') {
                steps {
                    script {
                        sh '''
                            # Ensure the instance ID file exists before proceeding
                            while [ ! -f instance_id.txt ]; do
                                sleep 5
                            done
                            
                            # Read the Instance ID from the file
                            INSTANCE_ID=$(cat instance_id.txt)
                            
                            # Create a new AMI from the instance
                            AMI_ID=$(aws ec2 create-image --region ap-south-1 --instance-id $INSTANCE_ID \
                                --name myAMI \
                                --description "Custom AMI created via Jenkins" \
                                --no-reboot --output text)
                            
                            # Save the AMI ID to a file
                            echo $AMI_ID > ami_id.txt
                        '''
                    }
                }
            }
        }
    }
}
