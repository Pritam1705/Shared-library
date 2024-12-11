def call() {
    sh '''
        git config --global user.name "Pritam1705"
        git config --global user.email "kondapratiwarpritam855@gmail.com"
        touch file.txt
        git add file.txt 
        git commit -m "Added with sign-off"
    '''
}


