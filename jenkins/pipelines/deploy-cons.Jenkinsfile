@Library('hybris-pipeline-libraries')_

def configs = [:]

pipeline {

  agent any

  stages {

    stage('Load Properties') {
      steps {    
        script {
          configs = loadProperties()
          configs.ant_instalation = 'deploy-cons'
          configs.environment_name = 'dev'
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
