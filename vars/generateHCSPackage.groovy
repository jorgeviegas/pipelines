#!/usr/bin/env groovy

def call(Map conf = [:], String env) {

    dir (conf.hybris_home) {
     
        // Clear temp hcs packages
        sh 'rm -rf temp_hcs_package'
        sh 'mkdir temp_hcs_package'

    }
    
    unzip zipFile:conf.hcs_package_skeleton, dir:"${conf.hybris_home}/temp_hcs_package", quiet:true
   
    dir (conf.hybris_home) {

        sh "cp temp/hybris/hybrisServer/hybrisServer-AllExtensions.zip temp_hcs_package/hcs_package_skeleton/hybris/bin"
        sh "cp temp/hybris/hybrisServer/hybrisServer-Platform.zip temp_hcs_package/hcs_package_skeleton/hybris/bin"
        
        sh "cp config/local.properties temp_hcs_package/hcs_package_skeleton/hybris/config/stag/customer.properties"

        def packageName = "${conf.hcs_customer_id}-${conf.hcs_project_id}_${conf.hcs_package_version}"
        echo packageName

        // ssh

    }
}