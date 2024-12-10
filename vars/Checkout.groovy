def call() {
    stage('Clone_repo') {
        git branch: 'main', url: 'https://github.com/OT-MICROSERVICES/salary-api.git'
    }
}
