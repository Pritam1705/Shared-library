def call() {
   withCredentials([[$class: 'AmazonWebServicesCredentialsBinding', credentialsId: 'AWS-key']]) {
    sh "packer build -var \"region=ap-south-1\" packer-template.json"
}

}
