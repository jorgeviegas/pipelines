#!/usr/bin/env groovy

def call() {
	dir ("${binaries_home}"){
		// remove platform binaries
		sh 'rm -rf ext-* platform'
	}
}
