#!/usr/bin/env groovy

def call() {
	dir (env.BINARIES_HOME){
		unzip zipFile:env.HYBRIS_ZIP, glob:'hybris/bin/*', quiet:true
	}
}
