#!/usr/bin/env groovy

def call(Map conf = [:]) {

  dir(conf.fortify_binaries){
    echo "./sourceanalyzer -b ${conf.fortify_buildID} -cp ${workspace}${conf.fortify_javaFiles} -exclude \"${workspace}${conf.fortify_excludeGenSrc}\""
    sh "./sourceanalyzer -b ${conf.fortify_buildID} -cp ${workspace}/${conf.fortify_javaFiles} -exclude \"${workspace}/${conf.fortify_excludeTest}:${workspace}/${conf.fortify_excludeGenSrc}\""
    sh "./sourceanalyzer -b ${conf.fortify_buildID} -cp ${workspace}/${conf.fortify_jsFiles} -exclude \"${workspace}/${conf.fortify_exclude_UI}:${workspace}/${conf.fortify_exclude_UISource}\""
    sh "./sourceanalyzer -b ${conf.fortify_buildID} -scan -f ${workspace}/${conf.fortify_scanFilePath}"
  }
}
//
