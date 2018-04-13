#!/usr/bin/env groovy

def call(Map conf = [:]) {

   // withSonarQubeEnv('chedraui-sonar-qube'){
   		echo "${workspace}"
        def scannerHome = tool 'chedraui-sonar-scanner';
        dir (workspace + conf.sonar_configuration_path) {
            sh "${scannerHome}/bin/sonar-scanner"
        }
	// }
}