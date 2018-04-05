#!/usr/bin/env groovy

def call(String platform = '') {
    dir (platform){
        sh 'chmod +x setantenv.sh'
        sh '. ./setantenv.sh'
        sh 'chmod +x hybrisserver.sh'   
        sh 'chmod +x tomcat/bin/*.sh'
        sh './hybrisserver.sh stop'
    }
}