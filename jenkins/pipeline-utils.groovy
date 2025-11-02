@Library('jenkins-exercises-shared-lib')_

pipeline {
    agent any

    tools {
        nodejs "NodeJS"
    }

    stages {
        stage('Install Dependencies') {
            steps {
                installDependencies()
            }
        }

        stage('Run Tests') {
            steps {
                runTests()
            }
        }

        stage('Increment Version') {
            steps {
                incrementVersion()
            }
        }

        stage('Build') {
            steps {
                buildApp()
            }
        }

        stage('Commit Version Change') {
            steps {
                commitVersionChange()
            }
        }

        stage('Deploy') {
            steps {
                deployApp()
            }
        }
    }
}
