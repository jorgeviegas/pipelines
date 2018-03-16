#!/usr/bin/env groovy

def call(String platform = '', String hybrisHome = '') {

   withAnt(installation: 'hybris-ant'){
    	dir (platform) {
    		sh 'pwd'
     		sh 'ant clean'
    	}
	}

    dir (hybrisHome) {
     	sh 'ant envconfig'
    }
}