package grails.plugin.gamify

class ActivityType {

    String label
    BigInteger points = 0
    BigInteger cash = 0

    static constraints = {
    }
}
