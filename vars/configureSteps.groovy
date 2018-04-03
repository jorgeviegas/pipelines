#!/usr/bin/env groovy

def call() { 
	def version = "1.2"
    switch(GIT_BRANCH) {
    	case "develop":
            result = "dev"
    		break
  		default:
    		result = "def"
    		break
	}
	echo "${result}"
}