@Library('hybris-pipeline-libraries')_

def configs = [:]

pipeline {

  agent any

  stages {

    stage('Load Properties') {
      steps {    
        script {
          configs = loadProperties()
        }
      }
    } 

    stage('Sonar') {
      steps {
        sonarQube configs
      }
    }
  }

  post {
    // change to: success
    always {
      echo 'Storing artifacts'
      echo "${configs.sonar_artifact_folder}/**"
      echo "${configs.sonar_artifact_folder}/**"
      archiveArtifacts "${configs.sonar_artifact_folder}/**"
    }
  }
}
