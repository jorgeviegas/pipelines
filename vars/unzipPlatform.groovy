#!/usr/bin/env groovy

def call() {
	unzip zipFile:props.hybris_zip, glob:'**/hybris/bin/**', quiet:true
}
