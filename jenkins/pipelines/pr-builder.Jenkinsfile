@Library('hybris-pipeline-libraries')_

pipeline {

  environment {
     PROPS = readProperties(file:"jenkins/pipeline.properties")
   }

  agent any

  stages {

    stage('Load Proeprties') {
      steps {    
        echo env.PROPS['hcs_project_id']
      }
    } 

    stage('Reset Platform') {
      steps {         
        erasePlatform env.PROPS
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
