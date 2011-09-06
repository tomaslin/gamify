package grails.plugin.gamify

class Player {

    def gameService

    BigInteger points =  0
    BigInteger cash = 0
    Level level

    static hasMany = [ activities : Activity, badges : Badge ]

    def addActivity( activity ){

        gameService.addActivity( this, activity )

    }

    def deleteActivity( activity ){

        gameService.deleteActivity( this, activity )

    }

    static constraints = {

    }
}
