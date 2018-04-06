@Library('hybris-pipeline-libraries')_

def configs = [:]

pipeline {

  agent any


  stages {
  node {

    stage('Load Properties') {
      steps {    
        script {
          configs = loadProperties()
          configs.ant_instalation = 'hybris-cons-ant'
          configs.environment_name = 'dev'
        }
      }
    } 

    stage('Reset Platform') {
      steps {           
   //     erasePlatform configs
     //   unzipPlatform configs 
        echo 'out'
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
  } }
}
