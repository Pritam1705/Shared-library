def call() {

            sh '''
                packer validate packer-template.json
            '''
}
