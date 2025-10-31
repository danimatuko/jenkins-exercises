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

        stage('Build') {
            steps {
                script {
                    utils.buildApp()
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
