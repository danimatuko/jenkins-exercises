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

def incrementVersion(){
    dir('app') {
        sh 'npm version patch'

        def packageJson = readJSON file: 'package.json'
        env.APP_VERSION = packageJson.version
    }
} 

def buildApp() {
    echo '🏗️ Building the application...'
    echo "Building version: ${env.APP_VERSION}"
    sh "docker build -t node-app:${env.APP_VERSION} ."
}

def deploy() {
    echo "🚀 Deploying branch: ${env.BRANCH_NAME}"
}

return this
