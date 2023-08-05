pipeline {

    options {
        buildDiscarder(logRotator(numToKeepStr: '5', artifactNumToKeepStr: '5'))
    }

    agent any

    tools {
        maven 'Maven3.8.8'
    }

    stages {
        stage('Code Compilation') {
            steps {
                echo 'code compilation is starting'
                sh 'mvn clean compile'
				echo 'code compilation is completed'
            }
        }

        stage('Code Package') {
            steps {
                echo 'code packing is starting'
                sh 'mvn clean package'
				echo 'code packing is completed'
            }
        }
        stage('Building & Tag Docker Image') {
                    steps {
                        echo 'Starting Building Docker Image'
                        sh 'docker build -t sandipwn/travelbooking-ms .'
                        sh 'docker build -t travelbooking-ms .'
                        echo 'Completed  Building Docker Image'
                    }
        }

    }
}

