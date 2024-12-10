def call() {
    stage('Cred-scanning') {
         post {
        success {
            slackSend(channel: '#jenkinnotify', message: "Build SUCCESS: ${env.JOB_NAME} #${env.BUILD_NUMBER} (${branchName})", color: "good")
        }
        failure {
            slackSend(channel: '#jenkinnotify', message: "Build FAILURE: ${env.JOB_NAME} #${env.BUILD_NUMBER} (${branchName})", color: "danger")
        }
        always {
            echo "Build finished: ${currentBuild.currentResult}"
        }
     }
    }
}
