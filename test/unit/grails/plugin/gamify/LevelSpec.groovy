package grails.plugin.gamify

import grails.plugin.spock.*

class LevelSpec extends UnitSpec {

    def setup(){
        mockDomain( Level )
    }

    def "levels convert to the highest point threshold"() {

        when:
            new Level( label: 'newbie', points: 0 ).save( validate: false )
            new Level( label: 'legend', points: 50 ).save( validate: false )
            new Level( label: 'god', points: 75 ).save( validate: false )

        then:
            Level.fromPoints( 0 ).label == 'newbie'
            Level.fromPoints( 30 ).label == 'newbie'
            Level.fromPoints( 50 ).label == 'legend'
            Level.fromPoints( 100 ).label == 'god'

    }

    def "Cannot create 2 levels of the same point value"(){

        when:
            new Level( label: 'one', points:10 ).save( validate: false )

        then:
            new Level( label: 'two', points:10 ).validate() == false

    }

    def "points below lowest level should return null"(){

        when:
            new Level( label: 'newbie', points: 0 ).save( validate: false )

        then:
            Level.fromPoints( -20 ) == null

    }

}