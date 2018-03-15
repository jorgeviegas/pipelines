def call(text, channel) {
    def slackURL = 'https://hooks.slack.com/services/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'
    def payload = JsonOutput.toJson([text      : text,
                                     channel   : channel,
                                     username  : "jenkins",
                                     icon_emoji: ":jenkins:"])
    sh "curl -X POST --data-urlencode \'payload=${payload}\' ${slackURL}"
}