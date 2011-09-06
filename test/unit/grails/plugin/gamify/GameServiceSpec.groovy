package grails.plugin.gamify

import spock.lang.*
import grails.plugin.spock.*

class GameServiceSpec extends UnitSpec {

    GameService service
    Player player

    def setup(){

        mockDomain( Player )
        mockDomain( Level )
        mockDomain( Activity )
        mockDomain( ActivityType )
        service = new GameService()

    }

    def "adding activities increases points and cash"(){

        setup:
            def activityType = new ActivityType( points: points, cash: cash )
            def activity = new Activity( type : activityType )

        when: 'start with a new player'
            player = new Player()

        then: 'initial values are 0'
            player.points == 0
            player.cash == 0

        when: 'add the activity'
            service.addActivity( player, activity )

        then: 'point and cash levels are changed for the player'
            player.points == pointsFinal
            player.cash == cashFinal

        where:
            points | cash | pointsFinal | cashFinal
            0      | 100  | 0           | 100
            0      | -100 | 0           | -100
            100    | 100  | 100         | 100
            100    | 0    | 100         | 0

    }


    def "adding activities increases levels"(){

    }

    def "removing activities decreases levels"(){

    }

    def "when a level is changed, the service returns true"(){

    }

    def "when a badge is awarded, the service returns true"(){

    }


}