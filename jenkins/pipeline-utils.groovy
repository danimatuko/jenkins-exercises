def installDependencies() {
    dir('app') {
        echo "📦 Installing dependencies..."
        sh 'npm install'
    }
}

def runTest() {
    dir('app') {
        echo "🧪 Running tests..."
        sh 'npm test'
    }
}

def buildApp() {
    echo '🏗️ Building the application...'
    sh "docker build -t node-app:latest ."
}

def deploy() {
    echo "🚀 Deploying branch: ${env.BRANCH_NAME}"
}

return this
