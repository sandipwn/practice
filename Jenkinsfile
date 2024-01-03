pipeline{
    stages{
       stage('Code Compilation'){
         steps{
            sh 'mvn clean compile'
         }
       }
       stage('Code Test'){
         steps{
            sh 'mvn clean test'
         }
       stage('Code Package'){
         steps{
           sh 'mvn clean package'
           }
         }
       }
    }
}
