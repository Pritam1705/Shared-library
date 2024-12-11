def call() {
    sh """
        git status || echo 'Git repository not initialized'
        git config --global user.name "Pritam1705"
        git config --global user.email "kondapratiwarpritam855@gmail.com"
        git status
        touch file.txt
        git add .
        git commit -s -m "Added with sign-off"
    """
}



