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

    stage('Generate Fortify Build') {
      steps {
        buildFortify configs
      }
    }
  }
}
