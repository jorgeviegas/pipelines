@Library('hybris-pipeline-libraries')_

def configs = [:]

pipeline {

  agent any

  stages {

    stage('Load Properties') {
      steps {    
        script {
          configs = loadProperties()
          configs.ant_instalation = 'pr-builder'
        }
      }
    } 

    stage('Reset Platform') {
     steps {         
        erasePlatform configs
        unzipPlatform configs 
      }
    } 

    stage('Build') {
      steps {
        antBuilds configs
      }
    }

    stage('Run Unit Tests') {
      steps {   
        runUnitTests configs
      }
    }
  }
}
