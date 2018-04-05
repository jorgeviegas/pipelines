@Library('hybris-pipeline-libraries')_

pipeline {

  environment {
     PROPS = ""
   }

  agent any

  stages {

    stage('Load Proeprties') {
      steps {    
        script{
          PROPS = readProperties(file:"jenkins/pipeline.properties")
        }
      }
    } 

    stage('Reset Platform') {
      steps {         
        erasePlatform()
        unzipPlatform() 
      }
    } 

    stage('Build') {
      steps {
        antBuilds()
      }
    }

    stage('Run Unit Tests') {
      steps {   
        runUnitTests()
      }
    }
  }
}
