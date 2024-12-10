def call() {
   
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
