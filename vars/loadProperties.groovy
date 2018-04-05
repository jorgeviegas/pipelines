#!/usr/bin/env groovy

def call() {
    readProperties file:"${workspace}/jenkins/pipeline.properties"
}