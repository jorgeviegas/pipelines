#!/usr/bin/env groovy

def call(Map config = [:]) {
	dir (config['hcs_customer_id']){
		// remove platform binaries
		sh 'rm -rf ext-* platform'
	}
}
