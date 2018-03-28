#!/usr/bin/env groovy

def call(boolean hcsStructure = false) {

   withAnt(installation: 'hybris-ant'){

        dir (env.HYBRIS_HOME) {
            sh 'rm -rf config'
            sh "rm -rf ${env.HCS_PACKAGES_FOLDER}/*"
        }

        dir (env.PLATFORM_HOME) {
    		sh 'chmod +x apache-ant-1.9.1/bin/ant'

     		sh 'ant clean -Dinput.template=develop'
        }

        dir (env.HYBRIS_HOME) {
            sh "ant envconfig -Denvironment=${env.ENVIRONMENT_NAME}"
        }

        dir (env.PLATFORM_HOME) {

            sh "ant customize"
            
            try {
                sh "ant reinstall_addons -Dtarget.storefront=${env.STOREFRONT_NAME}"
            }
            catch(exc) {
                echo 'Error during reinstall_addons. Maybe you dont have any addons to install?'
            }  

            sh "ant production"

    	}


    	dir (env.HYBRIS_HOME) {
     
            sh 'rm -rf temp_hcs_package'
            sh 'mkdir temp_hcs_package'

            unzip zipFile:env.HCS_PACKAGE_SKELETON, dir:'temp_hcs_package', quiet:true

            sh "cp temp/hybris/hybrisServer/hybrisServer-AllExtensions.zip temp_hcs_package/hcs_package_skeleton/hybris/bin"
            sh "cp temp/hybris/hybrisServer/hybrisServer-Platform.zip temp_hcs_package/hcs_package_skeleton/hybris/bin"

            if (env.HCS_DEV_DEPLOY == 'master') {
                sh "cp config/local.properties temp_hcs_package/hcs_package_skeleton/hybris/config/dev/customer.properties"
            }

             if (env.HCS_DEV_DEPLOY == 'master') {
                sh "cp config/local.properties temp_hcs_package/hcs_package_skeleton/hybris/config/dev/customer.properties"
            }

             if (env.BRANCH_NAME == 'master') {
                sh "cp config/local.properties temp_hcs_package/hcs_package_skeleton/hybris/config/dev/customer.properties"
            }


        }
	}  
}