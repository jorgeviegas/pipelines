#!/usr/bin/env groovy

def call(String hybrisBinFolder = '', String hybrisBinZipFolder = '') {
	
	dir (hybrisBinFolder){
		unzip hybrisBinZipFolder
	}
}
