@Library('hybris-pipeline-libraries')_

def configs = [:]

pipeline {

  agent any

  stages {

    stage('Load Properties') {
      steps {    
        script {
          configs = loadProperties()

          // change below your pipeline specific properties
          configs.ant_instalation = 'hybris-cons-ant'
        }
      }
    } 

    stage('Reset Platform') {
      steps {           
        erasePlatform configs
        unzipPlatform configs 
      }
    } 

    stage('Generate Deployable') {
      steps {   
        generateDeployable configs
      }
    }

    stage('Deploy to Consolidation') {
      steps {   
        deployToConsolidation configs
      }
    }  
  }
}
