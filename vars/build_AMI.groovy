def call() {
   withCredentials([[$class: 'AmazonWebServicesCredentialsBinding', credentialsId: "${awsCredentialsId}"]]) {
                        sh "packer build -var 'region=${awsRegion}' ${packerTemplate}"
}
