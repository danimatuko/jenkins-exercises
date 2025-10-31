def utils // declare globally

pipeline {
    agent any

    stages {
        stage('Init') {
            steps {
                script {
                   utils = load 'jenkins/pipeline-utils.groovy'
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
