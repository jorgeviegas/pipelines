@Library('hybris-pipeline-libraries@feature/sonar')_

def configs = [:]

pipeline {

  agent any

  stages {

    stage('Load Properties') {
      steps {    
        script {
          configs = loadProperties()
          // configs.ant_instalation = 'deploy-stag'
          // configs.environment_name = 'hcs-stag'
        }
      }
    } 

    stage('Sonar'){
      steps {   
        sonarQube configs
      }
    }  
  } 
}
