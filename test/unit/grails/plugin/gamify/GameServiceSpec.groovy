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

    def "adding activities increases experience and credits"(){

        setup:
            def activityType = new ActivityType( experience: experience, credits: credits )
            def activity = new Activity( type : activityType )

        when: 'start with a new player'
            player = new Player()

        then: 'initial values are 0'
            player.experience == 0
            player.credits == 0

        when: 'add the activity'
            service.addActivity( player, activity )

        then: 'point and credits levels are changed for the player'
            player.experience == experienceFinal
            player.credits == creditsFinal

        where:
            experience  | credits | experienceFinal    | creditsFinal
            0           | 100     | 0                  | 100
            0           | -100    | 0                  | -100
            100         | 100     | 100                | 100
            100         | 0       | 100                | 0

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