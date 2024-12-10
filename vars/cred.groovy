def call() {
    stage('Cred-scanning') {
          sh 'gitleaks detect -v --report-path=gitleaks-report.json --report-format=json'
    }
}


