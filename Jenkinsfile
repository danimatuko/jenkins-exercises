pipeline {
    agent any

    stages {
        stage('Init') {
            steps {
                script {
                    utils = load 'jenkins/pipeline_utils.groovy'
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

        stage('Test') {
            steps {
                script {
                    utils.runTest()
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
