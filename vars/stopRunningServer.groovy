#!/usr/bin/env groovy

def call(String platform = '') {
    dir (platform){
        sh 'chmod +x hybrisserver.sh'   
        sh 'chmod +x tomcat/bin/*.sh'
        sh './hybrisserver.sh stop'
    }
}