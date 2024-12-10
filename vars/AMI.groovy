def call() {
    stage('Launch Instance') {
        steps {
             sh '''
                # Launch the EC2 instance
                aws ec2 run-instances --region ap-south-1 --image-id ami-053b12d3152c0cc71 \
                    --instance-type t2.micro \
                    --key-name jenkins  \
                    --security-group-ids sg-072642f94d7118f38 \
                    --subnet-id subnet-0c7dc48384c529638  > instance_info.json
                
                # Extract the Instance ID
                INSTANCE_ID=$(jq -r '.Instances[0].InstanceId' instance_info.json)
                echo $INSTANCE_ID > instance_id.txt
                '''
        }
    }

    stage('Wait for 30 Seconds') {
        steps {
            script {
                echo 'Waiting for 30 seconds before proceeding to the next stage.'
                sleep(30) // Correct usage in Groovy, not in shell
            }
        }
    }

    stage('Create AMI') {
        steps {
            sh '''
                # Read the Instance ID from the file
                INSTANCE_ID=$(cat instance_id.txt)
                
                # Create a new AMI from the instance
                AMI_ID=$(aws ec2 create-image --region ap-south-1  --instance-id $INSTANCE_ID \
                    --name MyAMI \
                    --description "Custom AMI created via Jenkins" \
                    --no-reboot --output text)
                
                # Save the AMI ID to a file
                echo $AMI_ID > ami_id.txt
                '''
        }
    }
}
