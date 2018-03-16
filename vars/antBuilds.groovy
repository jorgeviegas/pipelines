#!/usr/bin/env groovy

def call(String platform = '', String hybrisHome = '') {

    dir (platform) {
     	sh '. ./setantenv.sh'
    }

      dir (platform) {
     	sh 'ant clean'
    }

    dir (hybrisHome) {
     	sh 'ant envconfig'
    }
}