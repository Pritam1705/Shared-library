def call() {
    
          sh '''
                git config user.name Pritam1705
                git config user.email kondapratiwarpritam855@gmail.com

                # Amend the last commit to add a sign-off
                git commit --amend --no-edit --signoff
                '''
}

