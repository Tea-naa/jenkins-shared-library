def call() {
    withCredentials([usernamePassword(
        credentialsId: 'github-credentials',
        usernameVariable: 'GITHUB_USER',
        passwordVariable: 'GITHUB_TOKEN'
    )]) {
        sh '''
            git config user.name "Jenkins"
            git config user.email "jenkins@local"

            git add package.json package-lock.json
            git commit -m "Update app version"

            git push https://$GITHUB_USER:$GITHUB_TOKEN@github.com/Tea-naa/jenkins-ci-cd-pipeline.git HEAD:main
        '''
    }
}