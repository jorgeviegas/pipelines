@Library('hybris-pipeline-libraries')_

def configs = [:]

pipeline {

  agent any


  stages {

    stage('Load Properties') {
      steps {    
          node {

        script {
          configs = loadProperties()
          configs.ant_instalation = 'hybris-cons-ant'
          configs.environment_name = 'dev'
        }}
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
        node{ 
          generateDeployable configs
        }
      }
    }

    stage('Deploy to Consolidation') {
      steps {   
        deployToConsolidation configs
      }
    }  
  } 
}
