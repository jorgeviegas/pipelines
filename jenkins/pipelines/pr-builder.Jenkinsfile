@Library('hybris-pipeline-libraries')_

node{
  def props = readProperties(file:"jenkins/pipeline.properties")
}

pipeline {

  agent any

  stages {

    stage('Load Proeprties') {
      steps {    
        echo props['hcs_customer_id']
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
