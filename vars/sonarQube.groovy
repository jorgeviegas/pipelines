#!/usr/bin/env groovy

def call(Map conf = [:]) {

   // withSonarQubeEnv('chedraui-sonar-qube'){
    	
        def scannerHome = tool 'chedraui-sonar-scanner';
        dir (conf.sonar_configuration_file) {
            sh "${scannerHome}/bin/sonar-scanner"
        }
	// }
}