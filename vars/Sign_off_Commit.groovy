def call() {
    sh """
        git config user.name "Pritam1705"
        git config user.email "kondapratiwarpritam855@gmail.com"
        touch file.txt
        git add .
        git commit -s -m "Added with sign-off"
    """
}


