@Library('hybris-pipeline-libraries')_

pipeline {

  agent any

  environment {
   
    STOREFRONT_NAME          = 'athenasstorefront'
    PROJECT_PACKAGE          = 'com.sap.cd.b2bmvp'
 
    PLATFORM_HOME            = 'hybris/bin/platform'
    BINARIES_HOME            = 'hybris/bin/'
    HYBRIS_HOME              = "${workspace}/hybris"
    ANT_INSTALATION          = 'hybris-ant'
   
    SLACK_CHANNEL            = 'pipelines'
    SLACK_ENDPOINT           = 'https://hooks.slack.com/services/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'
    JUNIT_RESULT             = 'hybris/log/junit/TESTS-TestSuites.xml'
     
    HYBRIS_ZIP               = '/Users/i848340/binaries/hybris-6.4.0.0.zip'
  }

  stages {
    stage('Reset Platform') {
      when { 
        beforeAgent true
        anyOf { 
          environment name: 'RUN_RESET_PLATFORM_STEP', value: 'true'
        }
      }
      steps {           
        erasePlatform()
        unzipPlatform() 
      }
    } 

    stage('Build') {
      when { 
        beforeAgent true
        anyOf { 
          branch 'full-reports';
          branch 'pr-builder';
          environment name: 'RUN_BUILD_STEP', value: 'true'
        }
      }
      steps {
        antBuilds()
      }
    }

    stage('Run Unit Tests') {
      steps {   
        runUnitTests()
      }
    }
  }
}
