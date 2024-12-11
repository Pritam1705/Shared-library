def call() {
    withCredentials([usernamePassword(credentialsId: 'git-cred', usernameVariable: 'Pritam1705', passwordVariable: 'GIT_PASSWORD')]) {
                    sh '''
                    git remote set-url origin https://Pritam1705:${GIT_PASSWORD}@github.com/Pritam1705/salary-api.git
                    # Push the updated commit forcefully to the branch
                    git push origin ${GIT_BRANCH} --force
                    '''
}
