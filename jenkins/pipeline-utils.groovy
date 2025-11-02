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
        sh 'npm version patch --no-git-tag-version'
        def packageJson = readJSON file: 'package.json'
        env.APP_VERSION = packageJson.version
    }
} 

def buildApp() {
    echo "🏗️ Building version: ${env.APP_VERSION}"
    sh "docker build -t node-app:${env.APP_VERSION} -t node-app:latest ."
}

def deploy() {
    echo "🚀 Deploying app..."
    // Stop/remove old container, then run new one
    sh '''
    docker stop my-node-app || true
    docker rm my-node-app || true
    docker run -d -p 3000:3000 --name my-node-app node-app:latest
    '''
}

return this
