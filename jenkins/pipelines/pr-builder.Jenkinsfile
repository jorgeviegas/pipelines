@Library('hybris-pipeline-libraries')_

def configs = [:]

pipeline {

  agent any

  stages {

    stage('Load Properties') {
      steps {    
        script {
          configs = loadProperties()
        }
      }
    } 

    //stage('Reset Platform') {
   //   steps {         
  //      erasePlatform configs
 //       unzipPlatform configs 
//      }
//    } 

    stage('Build') {
      steps {
        antBuilds configs
      }
    }

    stage('Run Unit Tests') {
      steps {   
        runUnitTests configs
      }
    }
  }
}
