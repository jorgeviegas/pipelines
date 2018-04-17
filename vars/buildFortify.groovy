#!/usr/bin/env groovy

def call(Map conf = [:]) {
  dir(conf.fortify_binaries){
    sh "./sourceanalyzer -b ${conf.fortify_buildID} -classpath ${workspace}/${conf.fortify_javaFiles} -exclude ${workspace}/${conf.fortify_excludeTest}:${workspace}/${conf.fortify_excludeGenSrc} ${workspace}/${conf.fortify_javaFiles} "
    sh "./sourceanalyzer -b ${conf.fortify_buildID} -classpath ${workspace}/${conf.fortify_jsFiles} -exclude ${workspace}/${conf.fortify_exclude_UI}:${workspace}/${conf.fortify_exclude_UISource} ${workspace}/${conf.fortify_jsFiles} "
    sh "./sourceanalyzer -b ${conf.fortify_buildID} -scan -f ${workspace}/${conf.fortify_scanFilePath}"
  }
}
//
