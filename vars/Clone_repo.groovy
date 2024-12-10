def call() {
    stage('Clone Repository') {
        git branch: 'main', url: 'https://github.com/OT-MICROSERVICES/salary-api.git'
    }
}
