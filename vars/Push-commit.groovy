def call() {
    withCredentials([usernamePassword(credentialsId: 'git-cred', usernameVariable: 'USERNAME', passwordVariable: 'GIT_PASSWORD')]) {
        sh """
            git remote set-url origin https://${USERNAME}:${GIT_PASSWORD}@github.com/Pritam1705/salary-api.git
            # Push the updated commit forcefully to the branch
            git push origin ${env.GIT_BRANCH} --force
        """
    }
}
