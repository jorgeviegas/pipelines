#!/usr/bin/env groovy

def call(String platform = '', String hybrisHome = '') {

   withSonarQubeEnv('chedraui-sonar-qube'){
    	
        def scannerHome = tool 'SonarQube Scanner 2.8';
	}  
}