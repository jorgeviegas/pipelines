#!/usr/bin/env groovy

def call(Map conf = [:]) {

   withAnt(installation: conf.ant_instalation){

        dir (conf.hybris_home) {
            sh 'rm -rf config'
        }

        dir (conf.platform_home) {
    		sh 'chmod +x apache-ant-1.9.1/bin/ant'

     		sh 'ant clean -Dinput.template=develop'
        }

        dir (conf.hybris_home) {
            sh "ant envconfig -Denvironment=${conf.environment_name}"
        }

        dir (conf.platform_home) {

            sh "ant customize"
            
            try {
                sh "ant reinstall_addons -Dtarget.storefront=${conf.storefront_name}"
            }
            catch(exc) {
                echo 'Error during reinstall_addons. Maybe you dont have any addons to install?'
            }  

            sh "ant production"

    	}
	}  
}