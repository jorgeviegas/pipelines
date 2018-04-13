#!/usr/bin/env groovy

def call(Map conf = [:]) {

   // withSonarQubeEnv('chedraui-sonar-qube'){
        def scannerHome = tool 'chedraui-sonar-scanner';
        dir (workspace) {
            sh "${scannerHome}/bin/sonar-scanner -Dproject.settings=" + conf.sonar_configuration_file
        }
	// }
}