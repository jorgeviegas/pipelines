#!/usr/bin/env groovy

def call(boolean hcsStructure = false) {

   withAnt(installation: 'hybris-ant'){

        dir (env.HYBRIS_HOME) {
            sh 'rm -rf config'
        }

        dir (env.HYBRIS_HOME) {
            sh "rm -rf ${env.HCS_PACKAGES_FOLDER}/*"
        }

        dir (env.PLATFORM_HOME) {
    		sh 'chmod +x apache-ant-1.9.1/bin/ant'
     		sh 'ant clean -Dinput.template=develop'
    	}

    	dir (env.HYBRIS_HOME) {
     		sh "ant envconfig -Denvironment=${env.ENVIRONMENT_NAME}"

            sh "cp temp/hybris/hybrisServer/hybrisServer-AllExtensions"
      
            sh 'rm -rf temp_hcs_package'
            sh 'mkdir temp_hcs_package'

            unzip zipFile:env.HCS_PACKAGE_SKELETON, dir:'temp_hcs_package' quiet:true
        }
	}  
}