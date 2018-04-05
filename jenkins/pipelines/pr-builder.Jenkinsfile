@Library('hybris-pipeline-libraries')_

pipeline {

  agent any

  stages {
    
    stage('Load Properties') {
      steps {           
        loadProperties() 
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
