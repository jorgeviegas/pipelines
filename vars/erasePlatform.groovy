#!/usr/bin/env groovy

def call() {
	dir (PROPS['binaries_home']){
		// remove platform binaries
		sh 'rm -rf ext-* platform'
	}
}
