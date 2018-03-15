#!/usr/bin/env groovy

def call(String platform = '', String hybrisHome = '') {

    dir (platform) {
     	sh '. ./setantenv.sh'
     	sh 'ant clean'
    }

    dir (hybrisHome) {
     	sh 'ant envconfig'
    }
}