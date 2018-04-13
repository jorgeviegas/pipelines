#!/usr/bin/env groovy

def call(Map conf = [:]) {

   // withSonarQubeEnv('chedraui-sonar-qube'){
        def scannerHome = tool 'chedraui-sonar-scanner';
        dir (workspace + conf.hybris_home) {
            sh "${scannerHome}bin/sonar-scanner -Dproject.settings=$workspace" + conf.sonar_configuration_file
        }
	// }
}