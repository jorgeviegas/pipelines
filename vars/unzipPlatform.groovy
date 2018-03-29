#!/usr/bin/env groovy

def call() {
	unzip zipFile:env.HYBRIS_ZIP, glob:'**/hybris/bin/**', quiet:true
}
