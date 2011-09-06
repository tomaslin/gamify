package grails.plugin.gamify

class Activity {

    static belongsTo = [ user: Player ]

    ActivityType type
    Date dateCreated
    Date lastUpdated
    String description

    static constraints = {

    }
}
