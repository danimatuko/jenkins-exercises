def utils // global declaration

pipeline {
    agent any

    tools {
        nodejs "NodeJS"
    }

    stages {
        stage('Init') {
            steps {
                script {
                    utils = load 'jenkins/pipeline-utils.groovy'
                }
            }
        }

        stage('Install Dependencies') {
            steps {
                script {
                    utils.installDependencies()
                }
            }
        }

        stage('Test') {
            steps {
                script {
                    utils.runTest()
                }
            }
        }

        stage('increment version'){
            steps {
                script {
                    utils.incrementVersion()
                }
            }
        }

        stage('Build') {
            steps {
                script {
                    utils.buildApp()
                }
            }
        }
        stage('Commit Version Change') {
            steps {
                dir('app') {
                    script {
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
            }
        }

        stage('Deploy') {
            steps {
                script {
                    utils.deploy()
                }
            }
        }
    }
}
