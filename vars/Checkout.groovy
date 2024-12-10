def call() {
    stage('Checkout') {
        git branch: 'main', url: 'https://github.com/OT-MICROSERVICES/salary-api.git'
    }
}
