def call() {
    stage('checkout') {
        git branch: 'main' , url: 'https://github.com/OT-MICROSERVICES/salary-api.git'
    }
}
