def call() {
    parallel(
        AMI_creation: {
            stage('AMI_creation') {
                script {
                    sh '''
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
        },
        Time_out: {
            stage('Time_out') {
                steps {
                    script {
                        sleep(30)
                    }
                }
            }
        },
        AMI_creation_repeat: {
            stage('AMI_creation_repeat') {
                script {
                    sh '''
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
    )
}
