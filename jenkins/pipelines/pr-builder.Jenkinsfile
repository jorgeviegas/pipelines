@Library('hybris-pipeline-libraries')_

pipeline {

  agent any

  stages {

    stage('Load Proeprties') {
      steps {    
        script {       
          def props = readJSON(file:"jenkins/properties.json")
          echo props['hcs_customer_id']

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
