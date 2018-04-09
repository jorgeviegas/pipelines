@Library('hybris-pipeline-libraries')_

def configs = [:]

pipeline {

  agent any

  stages {

    stage('Load Properties') {
      steps {    
        script {
          configs = loadProperties()
          configs.ant_instalation = 'deploy-stag'
          configs.environment_name = 'hcs-stag'
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

    stage('Generate HCS Package') {
      steps {   
         generateHCSPackage configs, 'stag'
      }
    }

    stage('Notifications'){
      steps {   
        notifySlack configs, "Deploy to HCS Staging is complete! <${configs.hcs_stag_url}| Link to storefront>", 'pipelines'
      }
    }  
  } 
}
