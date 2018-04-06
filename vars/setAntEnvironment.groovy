#!/usr/bin/env groovy

def call(String platform = '') {
    dir (platform){
        sh 'chmod +x setantenv.sh'
        sh '. ./setantenv.sh'
    }
}