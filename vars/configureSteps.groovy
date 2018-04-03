#!/usr/bin/env groovy

def call() { 
	def version = "1.2"
    switch(GIT_BRANCH) {
    	case "develop":
            BUILD_MODE = "dev"
    		break
  		default:
    		BUILD_MODE = "def"
    		break
	}
	echo "${BUILD_MODE}"
}