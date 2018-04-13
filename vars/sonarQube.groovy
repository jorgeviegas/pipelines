#!/usr/bin/env groovy

def call(Map conf = [:]) {

        def scannerHome = tool 'chedraui-sonar-scanner';
        dir (workspace) {
            sh "${scannerHome}bin/sonar-scanner -Dproject.settings=${conf.sonar_configuration_file}"
        }
}