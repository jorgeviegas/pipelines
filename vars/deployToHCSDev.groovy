#!/usr/bin/env groovy

def call() {

   dir (env.HYBRIS_HOME) {
     
        sh 'rm -rf temp_hcs_package'
        sh 'mkdir temp_hcs_package'

        unzip zipFile:env.HCS_PACKAGE_SKELETON, dir:'temp_hcs_package', quiet:true

        sh "cp temp/hybris/hybrisServer/hybrisServer-AllExtensions.zip temp_hcs_package/hcs_package_skeleton/hybris/bin"
        sh "cp temp/hybris/hybrisServer/hybrisServer-Platform.zip temp_hcs_package/hcs_package_skeleton/hybris/bin"     
    }
}