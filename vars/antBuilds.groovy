#!/usr/bin/env groovy

def call(Map conf = [:]) {

   withAnt(installation: conf['ant_instalation_pr_builder']){

    	dir (conf['platform_home']) {
    		sh 'chmod +x apache-ant-1.9.1/bin/ant'
     		sh 'ant clean -f="build.xml"'
    	}

    	 dir (conf['hybris_home']) {
     		sh "ant envconfig -Denvironment=cons"
     		
   		}

   		dir (conf['platform_home']) {
    		sh 'ant customize'

    		try {
    			sh "ant reinstall_addons -Dtarget.storefront=${conf['storefront_name']}"
    		}
    		catch(exc) {
    			echo 'Error during reinstall_addons. Maybe you dont have any addons to install?'
    		}   		
			
     		sh 'ant all'
    	}
	}  
}