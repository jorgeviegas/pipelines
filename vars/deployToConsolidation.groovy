#!/usr/bin/env groovy

def call(Map conf = [:]) {

    def consPlatform = "${conf.ycons_path}/hybris/bin/platform"
    def consHybris = "${conf.ycons_path}/hybris"
    
    stopRunningServer consPlatform

    // Remove old version platform binaries
    dir (consHybris){
        sh 'rm -rf bin config'
    }
    
    // Replace platform binaries with new version
    dir (conf.hybris_home){
        unzip zipFile:"temp/hybris/hybrisServer/hybrisServer-AllExtensions.zip", dir:"${conf.ycons_path}", quiet:true
        unzip zipFile:"temp/hybris/hybrisServer/hybrisServer-Platform.zip", dir:"${env.ycons_path}", quiet:true
        unzip zipFile:"temp/hybris/hybrisServer/hybrisServer-Config.zip", dir:"${env.ycons_path}", quiet:true        
        unzip zipFile:"temp/hybris/hybrisServer/hybrisServer-Licence.zip", dir:"${env.ycons_path}", quiet:true        
    }
    
    // Copy tomcat configuration and validate config folder
    dir(consPlatform){

        sh 'chmod +x apache-ant-1.9.1/bin/ant'

        withAnt(installation: 'hybris-cons-ant'){
            sh 'ant'
        }
    }
    
    // Start server with new version
    dir (consPlatform){
        sh './hybrisserver.sh start'
    }
}