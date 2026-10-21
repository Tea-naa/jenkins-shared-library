def call() {
    sh 'npm version minor --no-git-tag-version'
}