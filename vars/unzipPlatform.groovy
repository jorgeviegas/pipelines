#!/usr/bin/env groovy

def call(Map configs = [:]) {
	unzip zipFile:configs['hybris_zip'], glob:'**/hybris/bin/**', quiet:true
}
