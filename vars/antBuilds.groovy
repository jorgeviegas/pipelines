#!/usr/bin/env groovy

def call(String platform = '', String hybrisHome = '') {

   withAnt(installation: 'hybris-ant'){
    	dir (platform) {
    		sh 'chmod +x /Users/i848340/.jenkins/workspace/pipelines_pipelines_master-W7SQZS5ABY7IAIKK4C2KSUSI5GLX36NC3O2BK4J3KEMIYCXEJSFQ/hybris/bin/platform/apache-ant-1.9.1/bin/ant'
     		sh 'ant clean'
    	}

    	 dir (hybrisHome) {
     		sh 'ant envconfig'
     		
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