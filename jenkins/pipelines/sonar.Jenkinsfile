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

    stage('Sonar'){
      steps {   
        sonarQube configs.platform_home configs.hybris_home
      }
    }  
  } 
}
