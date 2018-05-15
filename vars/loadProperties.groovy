#!/usr/bin/env groovy

def Map call() {
    return readProperties(file:"jenkins/pipeline.properties")
}