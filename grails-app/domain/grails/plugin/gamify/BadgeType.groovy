package grails.plugin.gamify

class BadgeType {

    String label
    String image

    ActivityType activityType
    BigInteger activitiesNeeded

    static constraints = {
    }
}
