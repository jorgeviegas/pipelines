#!/usr/bin/env groovy

def call(String hybrisBinFolder = '') {
	dir (hybrisBinFolder){
		// remove platform binaries
		sh 'rm -rf ext-* platform'
	}
}
