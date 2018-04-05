#!/usr/bin/env groovy

def call(Map config) {
	dir (config['binaries_home']){
		// remove platform binaries
		sh 'rm -rf ext-* platform'
	}
}
