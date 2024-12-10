def call() {
    stage('clone-repo') {
        git branch: 'main' , url: 'https://github.com/OT-MICROSERVICES/salary-api.git'
    }
}
