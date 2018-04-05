@Library('hybris-pipeline-libraries')_
@Library('piper-lib') _

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

    stage('Generate Deployable') {
      steps {   
        generateDeployable()
      }
    }

    stage('Deploy to Consolidation') {
      steps {   
        deployToConsolidation()
      }
    }  
  }
}
