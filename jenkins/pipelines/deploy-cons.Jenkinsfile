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
    HCS_PACKAGES_FOLDER      = '/Users/i848340/hcs_packages'
    YCONS_PATH               = '/Users/i848340/athenas-consolidation'
    YCONS_PLATFORM_HOME      =  "${env.YCONS_PATH}/hybris/bin/platform"
    YCONS_HYBRIS_HOME        =  "${env.YCONS_PATH}/hybris"

    SLACK_CHANNEL            = 'pipelines'
    SLACK_ENDPOINT           = 'https://hooks.slack.com/services/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'
    JUNIT_RESULT             = 'hybris/log/junit/TESTS-TestSuites.xml'
     
    HYBRIS_ZIP               = '/Users/i848340/binaries/hybris-6.4.0.0.zip'
  }

  stages {

    stage('Load Properties') {
      steps {           
        loadProperties() 
      }
    }
    stage('Reset Platform') {
      steps {           
        erasePlatform()
        unzipPlatform() 
      }
    } 

    stage('Generate Deployable') {
      steps {   
        generateDeployable()
      }
    }

    stage('Deploy to Consolidation') {
      steps {   
        deployToConsolidation()
      }
    }  
  }
}
