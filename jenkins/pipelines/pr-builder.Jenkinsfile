@Library('hybris-pipeline-libraries')_

def props = readProperties file:"${workspace}/jenkins/pipeline.properties"

pipeline {

  agent any

  stages {

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
