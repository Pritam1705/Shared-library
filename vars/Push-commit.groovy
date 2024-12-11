def call() {
    withCredentials([usernamePassword(credentialsId: 'git-cred', usernameVariable: 'GIT_USER', passwordVariable: 'GIT_PASS')]) {
        sh """
            git remote set-url origin https://${GIT_USER}:${GIT_PASS}@github.com/Pritam1705/salary-api.git
            git push origin main --force
        """
    }
}
