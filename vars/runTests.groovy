#!/usr/bin/env groovy

def call(String platform = '', String junitResult = '/log/junit/TESTS-TestSuites.xml') {

   withAnt(installation: 'hybris-ant'){
    	dir (platform) {		
     		sh "ant unittests"
    	}
	
        junit "${junitResult}"
    }  
}