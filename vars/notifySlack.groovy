import groovy.json.JsonOutput

def call(text, channel) {
    def slackURL = '${env.SLACK_ENDPOINT}'
    def payload = JsonOutput.toJson([text      : text,
                                     channel   : channel,
                                     username  : "jenkins",
                                     icon_emoji: ":jenkins:"])
    sh "curl -X POST --data-urlencode \'payload=${payload}\' ${slackURL}"
}