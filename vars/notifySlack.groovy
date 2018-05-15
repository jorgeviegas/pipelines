import groovy.json.JsonOutput

def call(Map conf = [:], text, channel) {
    def slackURL = conf.slack_endpoint
    def payload = JsonOutput.toJson([text      : text,
                                     channel   : channel,
                                     username  : "jenkins",
                                     icon_emoji: ":jenkins:"])
    sh "curl -X POST --data-urlencode \'payload=${payload}\' ${slackURL}"
}