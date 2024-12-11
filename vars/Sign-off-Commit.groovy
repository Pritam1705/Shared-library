def call() {
    
          sh '''
            git config user.name "Pritam1705"
            git config user.email "kondapratiwarpritam855@gmail.com"
            touch file8
            git add .
            git commit --signoff -m "Your commit message"
            '''
}

