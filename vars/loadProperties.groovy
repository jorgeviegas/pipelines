#!/usr/bin/env groovy

def call(Map configs = [:]) {
    configs = readProperties(file:"jenkins/pipeline.properties")
}