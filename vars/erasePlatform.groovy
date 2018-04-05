#!/usr/bin/env groovy

def call(Map conf = [:]) {
	dir (conf.binaries_home){
		// remove platform binaries
		sh 'rm -rf ext-* platform'
	}
}
