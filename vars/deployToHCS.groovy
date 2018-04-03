#!/usr/bin/env groovy

def call() {

   dir (env.HYBRIS_HOME) {
     
        sh 'rm -rf temp_hcs_package'
        sh 'mkdir temp_hcs_package'

        unzip zipFile:env.HCS_PACKAGE_SKELETON, dir:'temp_hcs_package', quiet:true

        sh "cp temp/hybris/hybrisServer/hybrisServer-AllExtensions.zip temp_hcs_package/hcs_package_skeleton/hybris/bin"
        sh "cp temp/hybris/hybrisServer/hybrisServer-Platform.zip temp_hcs_package/hcs_package_skeleton/hybris/bin"

        if (env.HCS_DEV_DEPLOY == 'master') {
            sh "cp config/local.properties temp_hcs_package/hcs_package_skeleton/hybris/config/dev/customer.properties"
        }


        //rename file to  HCS_CUSTOMER_ID - HCS_PROJECT_ID - HCS_PACKAGE_VERSION      = 'v01.01'

        def packageName = 'CUSTOMER-PROJECTID_VERSION'
        packageName.replace('CUSTOMER', env.HCS_CUSTOMER_ID)
        packageName.replace('PROJECT', env.HCS_PROJECT_ID)
        packageName.replace('VERSION', env.HCS_PACKAGE_VERSION)

        echo packageName

        // ssh

    }
}