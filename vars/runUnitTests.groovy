#!/usr/bin/env groovy

def call(Map configs = [:]) {
   withAnt(installation: configs['ant_instalation']){
    	dir (configs['platform_home']) {		
     		sh "ant unittests"
    	}
	
        junit "${configs['junit_result']}"
    }  
}