def call() {
    stage('Cred-Scanning') {
        sh 'gitleaks detect -v --report-path=gitleaks-report.json --report-format=json'  
    }
}
