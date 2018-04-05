#!/usr/bin/env groovy

def call() {
   withAnt(installation: env.ANT_INSTALATION){
    	dir (env.PLATFORM_HOME) {		
     		sh "ant unittests"
    	}
	
        junit "${env.JUNIT_RESULT}"
    }  
}