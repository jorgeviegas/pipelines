#!/usr/bin/env groovy

def call() {

   withAnt(installation: 'hybris-ant'){

        dir (env.HYBRIS_HOME) {
            sh 'rm -rf config'
            sh "rm -rf ${env.HCS_PACKAGES_FOLDER}/*"
        }

        dir (env.PLATFORM_HOME) {
    		sh 'chmod +x apache-ant-1.9.1/bin/ant'

     		sh 'ant clean -Dinput.template=develop'
        }

        dir (env.HYBRIS_HOME) {
            sh "ant envconfig -Denvironment=${env.ENVIRONMENT_NAME}"
        }

        dir (env.PLATFORM_HOME) {

            sh "ant customize"
            
            try {
                sh "ant reinstall_addons -Dtarget.storefront=${env.STOREFRONT_NAME}"
            }
            catch(exc) {
                echo 'Error during reinstall_addons. Maybe you dont have any addons to install?'
            }  

            sh "ant production"

    	}
	}  
}