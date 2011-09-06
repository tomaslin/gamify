package grails.plugin.gamify

class Level {

    BigInteger points
    String label

    static fromPoints( points ){
        Level.findByPointsLessThanEquals( points, [ sort: 'points', order: 'desc' ])
    }

    static constraints = {
        points( unique: true )
    }
}
