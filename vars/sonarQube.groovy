#!/usr/bin/env groovy

def call(Map conf = [:]) {

        dir (workspace) {
            sh "${conf.sonar_scanner_home}/bin/sonar-scanner -Dproject.settings=${conf.sonar_config_folder}/sonar-project.properties"
        }
}