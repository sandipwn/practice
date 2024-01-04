pipeline{
    options{
    buildDiscarder(logRotator(numToKeepStr:'5',artifactNumToKeepStr:'5'))
    }

    agent {label 'jenkinsslave-pt1'}

    tools{maven 'maven_3.8.8'}

    stages{
       stage('Code Compilation'){
         steps{
            sh 'mvn clean compile'
         }
       }
       stage('Code Package'){
         steps{
            sh 'mvn clean package'
           }
         }
       }
}

