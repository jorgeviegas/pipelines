@Library('hybris-pipeline-libraries')_

def configs = [:]

pipeline {

  environment {
     PROPS = ""
   }

  agent any

  stages {

    stage('Load Properties') {
      steps {    
        configs = loadProperties
      }
    } 

    stage('Reset Platform') {
      steps {         
        erasePlatform configs
        unzipPlatform configs 
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
