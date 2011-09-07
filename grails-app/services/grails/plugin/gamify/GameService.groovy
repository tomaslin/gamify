package grails.plugin.gamify

class GameService {

    static transactional = true

    def addActivity( player, activity ){

        def activityType = activity.type

        player.addToActivities( activity )
        player.experience += activityType.experience
        player.credits += activityType.credits

        def newLevel = Level.fromExperience( player.experience )
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
