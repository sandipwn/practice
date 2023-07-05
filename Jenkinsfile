pipeline {
    options {
        buildDiscarder(logRotator(numToKeepStr: '5', artifactNumToKeepStr: '5'))
    }
    agent any
      tools {
        maven 'Maven3.8.8'
      }
      stages {
        stage ('Build') {
          steps {
            sh 'mvn clean package'
          }
        }
    }
}