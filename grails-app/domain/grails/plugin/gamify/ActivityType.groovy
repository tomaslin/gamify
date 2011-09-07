package grails.plugin.gamify

class ActivityType {

    String label
    BigInteger experience = 0
    BigInteger credits = 0

    static constraints = {
    }
}
