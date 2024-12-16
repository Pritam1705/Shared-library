def call() {
    // Set up Git user details
    sh '''
        git config --global user.name "Pritam1705"
        git config --global user.email "kondapratiwarpritam855@gmail.com"
        touch file2.txt
        git add file2.txt
        git commit -m "Added with sign-off"
    '''
    
    // Push the changes using credentials
   
}
