#!/usr/bin/env groovy

def call() {
	dir (env.BINARIES_HOME){
		// remove platform binaries
		sh 'rm -rf ext-* platform'
	}
}
