package grails.plugin.gamify

class GameService {

    static transactional = true

    def addActivity( player, activity ){

        def activityType = activity.type

        player.addToActivities( activity )
        player.points += activityType.points
        player.cash += activityType.cash

        def newLevel = Level.fromPoints( player.points )
        def levelChanged = newLevel == player.level

        player.level = newLevel
        player.save()

        def badgeAdded = false

        return [ levelChanged, badgeAdded ]

    }

    def deleteActivity( player, activity ){

        player.removeFromActivities( activity )
        player.save()

    }

    def activityStream( users ){

    }

    def leaderBoard( ){

    }

}
