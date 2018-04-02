#!/usr/bin/env groovy

def call() {

    // Stop hybris server
    dir (env.YCONS_PLATFORM_HOME){
        sh 'chmod +x setantenv.sh'
        sh '. ./setantenv.sh'
        sh 'chmod +x hybrisserver.sh'
        sh './hybrisserver.sh stop'
    }
    
    // Remove old version platform binaries
    dir ("${env.YCONS_PATH}/hybris"){
        sh 'rm -rf bin config'
    }
    
    // Replace platform binaries with new version
    dir (env.HYBRIS_HOME){
        unzip zipFile:"temp/hybris/hybrisServer/hybrisServer-AllExtensions.zip", dir:"${env.YCONS_PATH}", quiet:true
        unzip zipFile:"temp/hybris/hybrisServer/hybrisServer-Platform.zip", dir:"${env.YCONS_PATH}", quiet:true
        unzip zipFile:"temp/hybris/hybrisServer/hybrisServer-Config.zip", dir:"${env.YCONS_PATH}", quiet:true        
        unzip zipFile:"temp/hybris/hybrisServer/hybrisServer-Licence.zip", dir:"${env.YCONS_PATH}", quiet:true        
    }
    
    // Copy tomcat configuration and validate config folder
    dir(env.YCONS_PLATFORM_HOME){
        sh 'chmod +x setantenv.sh'
        sh '. ./setantenv.sh'
        sh 'chmod +x apache-ant-1.9.1/bin/ant'
        sh 'ant'
    }
    
    // Start server with new version
    dir (env.YCONS_PLATFORM_HOME){
        sh './hybrisserver.sh start'
    }
}