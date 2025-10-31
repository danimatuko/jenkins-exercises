def buildpp() {
    echo '🏗️ Building the application...'
}

def runTests() {
    echo '🧪 Running tests...'
}

def deploy() {
    echo "🚀 Deploying branch: ${env.BRANCH_NAME}"
}

return this
