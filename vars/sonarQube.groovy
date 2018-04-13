#!/usr/bin/env groovy

def call(Map conf = [:]) {

   // withSonarQubeEnv('chedraui-sonar-qube'){
    	echo "test test test"
        def scannerHome = tool 'chedraui-sonar-scanner';
        dir (conf.sonar_configuration_path) {
        	echo "test test test"
        	echo conf.sonar_configuration_path
            sh "${scannerHome}/bin/sonar-scanner"
        }
	// }
}