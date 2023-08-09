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
    stage('Sonarqube Code Quality') {
                environment {
                    scannerHome = tool 'qube'
                }
                steps {
                    withSonarQubeEnv('sonar-server') {
                        sh "${scannerHome}/bin/sonar-scanner"
                        sh 'mvn sonar:sonar'
                    }
                    timeout(time: 10, unit: 'MINUTES') {
                        waitForQualityGate abortPipeline: true
                    }
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
                        sh 'docker build -t sandipnaikwade/radical-ms .'
                        sh 'docker build -t radical-ms .'
                        echo 'Completed  Building Docker Image'
                    }
        }
        stage('Docker Image Scanning') {
                    steps {
                        echo 'Docker Image Scanning Started'
                        sh 'java -version'
                        echo 'Docker Image Scanning Started'
                    }
        }
        stage(' Docker push to Docker Hub') {
                   steps {
                      script {
                         withCredentials([string(credentialsId: 'dockerhubCred', variable: 'dockerhubCred')]){
                         sh 'docker login docker.io -u sandipnaikwade -p ${dockerhubCred}'
                         echo "Push Docker Image to DockerHub : In Progress"
                         sh 'docker push sandipnaikwade/radical-ms:latest'
                         echo "Push Docker Image to DockerHub : In Progress"
                         sh 'whoami'
                         }
                      }
                    }
        }
        stage(' Docker Image Push to Amazon ECR')
        {
                       steps {
                           script {
                                        withDockerRegistry([credentialsId:'ecr:ap-south-1:ecr-credentials', url:'https://336363707015.dkr.ecr.ap-south-1.amazonaws.com']){
                                        sh """
                                        docker build -t radical-ms .
                                        docker images
                                        docker tag radical-ms:latest 336363707015.dkr.ecr.ap-south-1.amazonaws.com/radical-ms:latest
                                        docker push 336363707015.dkr.ecr.ap-south-1.amazonaws.com/radical-ms:latest
                                        """
                                        }
                           }

                       }
        }
         stage('Upload the docker Image to Nexus') {
                   steps {
                      script {
                         withCredentials([usernamePassword(credentialsId: 'nexus', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]){
                         sh 'docker login http://3.110.209.226:8085/repository/radical-ms/ -u admin -p ${PASSWORD}'
                         echo "Push Docker Image to Nexus : In Progress"
                         sh 'docker tag radical-ms:latest 3.110.209.226:8085/radical-ms:latest'
                         sh 'docker push 3.110.209.226:8085/radical-ms:latest'
                         echo "Push Docker Image to Nexus : Completed"
                         }
                      }
                    }
         }
         stage('Delete docker image from Jenkins'){
                     steps{
                         script{
                         sh 'docker rmi -f $(docker images -q)'
                         }
                     }
         }
    }
}



