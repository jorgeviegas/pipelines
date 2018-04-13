#!/usr/bin/env groovy

def call(Map conf = [:]) {

        dir (workspace) {
            sh "${conf.sonar_scanner_bin}/sonar-scanner -Dproject.settings=${conf.sonar_configuration_file}"
        }
}