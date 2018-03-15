#!/usr/bin/env groovy

def call() {

    dir (env.PLATFORM_HOME) {
     	sh '. ./setantenv.sh'
     	sh 'ant clean'
    }

    dir (env.HYBRIS_HOME) {
     	sh 'ant envconfig'
    }
}