def call() {
    
          sh 'gitleaks detect -v --report-path=gitleaks-report.json --report-format=json'
    
}


