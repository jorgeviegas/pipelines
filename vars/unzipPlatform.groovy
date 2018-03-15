#!/usr/bin/env groovy

def call(String hybrisBinFolder = '', String hybrisBinZip = '') {
	
	dir (hybrisBinFolder){
		unzip hybrisBinZip, quiet:true
	}
}
