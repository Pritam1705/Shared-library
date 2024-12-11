def call() {
   
        sh """
            git remote set-url origin https://Pritam1705:Pritam1705@github.com/Pritam1705/salary-api.git
            # Push the updated commit forcefully to the branch
            git push origin main --force
        ""
}
