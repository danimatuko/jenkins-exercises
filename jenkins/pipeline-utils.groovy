def buildApp() {
    echo '🏗️ Building the application...'
}

def runTest() {
    echo '🧪 Running tests...'
}

def deploy() {
    echo "🚀 Deploying branch: ${env.BRANCH_NAME}"
}

return this
