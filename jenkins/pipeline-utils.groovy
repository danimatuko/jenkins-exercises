def buildApp() {
    echo '🏗️ Building the application...'
    sh "docker build -t node-app:latest ."
}

def runTest() {
    echo '🧪 Running tests...'
    sh "npm run test"
}

def deploy() {
    echo "🚀 Deploying branch: ${env.BRANCH_NAME}"
}

return this
