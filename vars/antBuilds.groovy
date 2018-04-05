#!/usr/bin/env groovy

def call(Map configs = [:], String envName) {

   withAnt(installation: configs['ant_instalation']){
    	dir (configs['platform_home']) {
    		sh 'chmod +x apache-ant-1.9.1/bin/ant'
     		sh 'ant clean'
    	}

    	 dir (configs['hybris_home') {
     		sh "ant envconfig -Denvironment=${envName}"
     		
   		}

   		dir (env.PLATFORM_HOME) {
    		sh 'ant customize'

    		try {
    			sh "ant reinstall_addons -Dtarget.storefront=${configs['storefront_name']}"
    		}
    		catch(exc) {
    			echo 'Error during reinstall_addons. Maybe you dont have any addons to install?'
    		}   		
			
     		sh 'ant all'
    	}
	}  
}