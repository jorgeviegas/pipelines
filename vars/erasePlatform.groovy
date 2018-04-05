#!/usr/bin/env groovy

def call() {
	dir (props['hcs_customer_id']){
		// remove platform binaries
		sh 'rm -rf ext-* platform'
	}
}
