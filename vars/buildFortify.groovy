#!/usr/bin/env groovy

def call(Map conf = [:]) {

  dir(conf.fortify_binaries){

    echo "whoami"

    echo "./sourceanalyzer -b ${conf.fortify.buildID} -cp ${workspace}${conf.fortify_javaFiles} -exclude \"${workspace}${conf.fortify_excludeGenSrc}\""

    sh "./sourceanalyzer -b ${conf.fortify.buildID} -cp ${workspace}${conf.fortify.javaFiles} -exclude \"${workspace}${conf.fortify.excludeTest}:${conf.fortify_excludeGenSrc}\""
    sh "./sourceanalyzer -b ${conf.fortify.buildID} -cp ${workspace}${conf.fortify.jsFiles} -exclude \"${workspace}${conf.fortify_exclude_UI}:${conf.fortify_exclude_UISource}\""
    sh "./sourceanalyzer -b ${conf.fortify.buildID} -scan -f ${conf.fortify.scanFilePath}"
  }
}
