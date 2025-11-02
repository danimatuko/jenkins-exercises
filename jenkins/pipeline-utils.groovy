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

def commitVersionChange(){
    dir('app') {
        withCredentials([usernamePassword(
            credentialsId: 'github-credentials', 
            usernameVariable: 'USER', 
            passwordVariable: 'PASS'
        )]) {
                def branch = env.BRANCH_NAME ?: 'main'

                echo "📤 Pushing version bump to branch: ${branch}"

                sh """
                    git config user.name "Jenkins CI"
                    git config user.email "jenkins@jenkins-exercises.com"
                    git add package.json package-lock.json
                    git commit -m "ci: bump version to ${env.APP_VERSION}"
                    git push https://${USER}:${PASS}@github.com/danimatuko/jenkins-exercises.git HEAD:${branch}
                    """
            }
    }

}


def deploy() {
    echo "🚀 Deploying app..."
    // Stop and remove old container, then run the latest
    sh '''
    docker stop my-node-app || true
    docker rm my-node-app || true
    docker run -d -p 3000:3000 --name my-node-app node-app:latest
    '''

    echo "✅ Deployment successful! App is running on port 3000."
}


return this
