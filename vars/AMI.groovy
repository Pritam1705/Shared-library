def call() {
    stage('Launch Instance') {
        steps {
            sh '''
                # Launch the EC2 instance
                aws ec2 run-instances --region "${region}" --image-id "${AMI_ID}" \
                    --instance-type "${instance_type}" \
                    --key-name "${key_name}"  \
                    --security-group-ids "${sg_id}" \
                    --subnet-id "${subnet_id}"  > instance_info.json
                
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
                AMI_ID=$(aws ec2 create-image --region "${region}" --instance-id $INSTANCE_ID \
                    --name "${AMI_NAME}" \
                    --description "Custom AMI created via Jenkins" \
                    --no-reboot --output text)
                
                # Save the AMI ID to a file
                echo $AMI_ID > ami_id.txt
            '''
        }
    }
}
