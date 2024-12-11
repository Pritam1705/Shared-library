def call() {
     slackSend(
        channel: '#jenkinnotify',
        message: "Find Status of Pipeline: ${currentBuild.currentResult} ${env.JOB_NAME} ${env.BUILD_NUMBER} ${BUILD_URL}"
    )
}



