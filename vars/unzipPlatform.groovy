#!/usr/bin/env groovy

def call(String hybrisBinFolder = '', String hybrisBinZip = '') {
	
	dir (hybrisBinFolder){
		unzip zipFile:hybrisBinZip, dir:, glob:'hybris/bin/**', quiet:true
	}
}
