package grails.plugin.gamify

import spock.lang.*
import grails.plugin.spock.*

class PlayerSpec extends UnitSpec {

    GameService gameService
    Player player

    def setup(){
        mockDomain( Player )
        mockDomain( Activity )
        gameService = Mock()
        player = new Player()
        player.gameService = gameService
    }

    def 'add activity calls out to game service'(){

        when:
            def activity = new Activity()
            player.addActivity( activity )
        then:
            0 * gameService.addActivity( _ )

    }

    def 'remove activity calls out to game service'(){

    }

    def 'initial level is set correctly'(){

    }

}