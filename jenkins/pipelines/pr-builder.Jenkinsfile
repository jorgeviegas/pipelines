@Library('hybris-pipeline-libraries')_

def configs = [:]

pipeline {

  environment {
     PROPS = ""
   }

  agent any

  stages {

    stage('Load Proeprties') {
      steps {    
        script{
          configs = readProperties(file:"jenkins/pipeline.properties")
        }
      }
    } 

    stage('Reset Platform') {
      steps {         
        erasePlatform configs
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
