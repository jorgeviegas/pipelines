#!/usr/bin/env groovy

def call() {

    dir ("${env.YCONS_PATH}/hybris"){
        // remove platform binaries
        sh 'rm -rf bin'
    }

    dir (env.HYBRIS_HOME){
        unzip zipFile:"temp/hybris/hybrisServer/hybrisServer-AllExtensions.zip", dir:"${env.YCONS_PATH}", quiet:true
        unzip zipFile:"temp/hybris/hybrisServer/hybrisServer-Platform.zip", dir:"${env.YCONS_PATH}", quiet:true
        unzip zipFile:"temp/hybris/hybrisServer/hybrisServer-Config.zip", dir:"${env.YCONS_PATH}", quiet:true        
   }

   withAnt('hybris-cons-ant'){
        dir("${env.YCONS_PATH}/hybris/bin/platform"){
            'sh ant'
        }
   }

}