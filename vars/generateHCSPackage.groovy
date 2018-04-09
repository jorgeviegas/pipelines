#!/usr/bin/env groovy

def call(Map conf = [:], String env) {

    dir (conf.hybris_home) {
        // Clear old hcs packages
        sh 'rm -rf hcs_package_skeleton'
    }
    
    unzip zipFile:conf.hcs_package_skeleton, dir:conf.hybris_home, quiet:true
   
    dir (conf.hybris_home) {

        sh "cp temp/hybris/hybrisServer/hybrisServer-AllExtensions.zip hcs_package_skeleton/hybris/bin"
        sh "cp temp/hybris/hybrisServer/hybrisServer-Platform.zip hcs_package_skeleton/hybris/bin"
        
        sh "cp config/local.properties hcs_package_skeleton/hybris/config/stag/customer.properties"

        def packageName = "${conf.hcs_customer_id}-${conf.hcs_project_id}_${conf.hcs_package_version}"
        echo packageName


        zip zipFile:packageName dir:"hcs_package_skeleton"

        // ssh pack to hcs

        // move package to archive
        sh "mv ${packageName} ${conf.hcs_packages_folder}"

        // Clear the workspace
        sh 'rm -rf hcs_package_skeleton'

    }
}