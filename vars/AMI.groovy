def call() {
    stage('Launch Instance') {
        steps {
            sh '''
                aws ec2 run-instances --region ap-south-1 --image-id ami-053b12d3152c0cc71 --instance-type t2.micro --key-name snatak --security-group-ids sg-0874a627ada42207f > instance_info.json
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
                INSTANCE_ID=$(cat instance_id.txt)
                AMI_ID=$(aws ec2 create-image --region ap-south-1 --instance-id $INSTANCE_ID --name "MyCustomAMI" --description "Custom AMI created via Jenkins" --no-reboot --output text)
                echo $AMI_ID > ami_id.txt
                '''
        }
    }
}
