def call() {
    script {
        // Ensure that the AWS credentials are available
        withCredentials([[$class: 'AmazonWebServicesCredentialsBinding', credentialsId: 'AWS-key']]) {
            // Write the packer configuration to a file
            writeFile file: 'packer-config.pkr.hcl', text: ''' 
packer {
required_plugins {
 amazon = {
   source  = "github.com/hashicorp/amazon"
   version = "~> 1"
 }
}
}
'''
        }
    }
}
