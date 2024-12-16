def call() {
    withCredentials([[$class: 'AmazonWebServicesCredentialsBinding', credentialsId: 'AWS-key']]) {
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
        sh 'packer init .'
    }
}

