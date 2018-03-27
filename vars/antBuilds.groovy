#!/usr/bin/env groovy

def call(String platform = '', String hybrisHome = '', String environmentName = '') {

   withAnt(installation: 'hybris-ant'){
    	dir (platform) {
    		sh 'chmod +x apache-ant-1.9.1/bin/ant'
     		sh 'ant clean'
    	}

        echo env.PLATFORM_HOME

    	 dir (hybrisHome) {
     		sh "ant envconfig ${environmentName}'"
     		
   		}

   		dir (platform) {
    		sh 'ant customize'

    		try {
    			sh 'ant reinstall_addons -Dtarget.storefront=athenasstorefront'	
    		}
    		catch(exc) {
    			echo 'Error during reinstall_addons. Maybe you dont have any addons to install?'
    		}   		
			
     		sh 'ant all'
    	}
	}  
}