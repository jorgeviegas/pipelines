@Library('hybris-pipeline-libraries')_



pipeline {

  agent any

  stages {

    stage('Load Proeprties') {
      steps {    
        script{
          def props = readProperties(file:"jenkins/pipeline.properties")
        }
      }
    } 

    stage('Reset Platform') {
      steps {  
        echo props['hcs_customer_id']
         
        erasePlatform props
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
