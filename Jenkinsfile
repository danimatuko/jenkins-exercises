@Library('jenkins-exercises-shared-lib')_

def utils // global declaration

pipeline {
    agent any

    tools {
        nodejs "NodeJS"
    }

    stages {
        stage('Test Shared Lib') {
            steps {
                logMessage('This is a test message to test the shared library integration')
            }
        }

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
                script {
                    utils.commitVersionChange()
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
