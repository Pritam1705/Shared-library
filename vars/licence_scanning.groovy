def call() {
    stage('licence_scanning') {
             sh 'fossa analyze'     
    }
}
