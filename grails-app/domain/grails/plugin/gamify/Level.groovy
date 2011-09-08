package grails.plugin.gamify

class Level {

    BigInteger experience
    String label

    static fromExperience( experience ){
        Level.findByExperienceLessThanEquals( experience, [ sort: 'experience', order: 'desc' ])
    }

    static nextLevel( experience ){
        Level.findByExperienceGreaterThan( experience, [ sort: 'experience', order: 'asc' ] )
    }

    static constraints = {
        experience( unique: true )
    }
}
