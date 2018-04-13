#!/usr/bin/env groovy

def call(Map conf = [:]) {

   // withSonarQubeEnv('chedraui-sonar-qube'){
        def scannerHome = tool 'chedraui-sonar-scanner';
        sh 'whoami'
        dir (conf.sonar_configuration_path) {
        	sh 'whoami'
            // sh "${scannerHome}/bin/sonar-scanner"
        }
	// }
}