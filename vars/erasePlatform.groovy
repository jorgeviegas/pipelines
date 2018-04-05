#!/usr/bin/env groovy

def call(Map configs = [:]) {
	dir (configs['binaries_home']){
		// remove platform binaries
		sh 'rm -rf ext-* platform'
	}
}
