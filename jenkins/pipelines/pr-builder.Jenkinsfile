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
