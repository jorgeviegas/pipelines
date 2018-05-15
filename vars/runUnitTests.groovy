#!/usr/bin/env groovy

def call(Map conf = [:]) {
   withAnt(installation: conf.ant_instalation){
    	dir (conf.platform_home) {		
     		sh "ant unittests"
    	}
	
        junit conf.junit_result
    }  
}