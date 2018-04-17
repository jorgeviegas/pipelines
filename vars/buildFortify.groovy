#!/usr/bin/env groovy

def call(Map conf = [:]) {

  dir(conf.fortify_binaries){

    echo './sourceanalyzer -b conf.fortify.buildID -cp ${workspace}conf.fortify_javaFiles -exclude \\"${workspace}${conf.fortify_excludeTestGenSrc}\\"'

    // sh './sourceanalyzer -b conf.fortify.buildID -cp ${workspace}conf.fortify.javaFiles -exclude "${workspace}${conf.fortify.excludeTestGenSrc}"'
    //sh '${conf.fortify_binaries}/sourceanalyzer -b conf.fortify.buildID -cp conf.fortify.jsFiles -exclude conf.fortify.excludeGeneratedJSFiles'
    // sh './sourceanalyzer -b conf.fortify.buildID -scan -f conf.fortify.scanFilePath'
  }
}
