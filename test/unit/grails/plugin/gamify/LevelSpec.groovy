package grails.plugin.gamify

import grails.plugin.spock.*

class LevelSpec extends UnitSpec {

    def setup(){
        mockDomain( Level )
    }

    def "levels convert to the highest point threshold"() {

        setup:
            setupLevels()

        expect:
            Level.fromExperience( 0 ).label == 'newbie'
            Level.fromExperience( 30 ).label == 'newbie'
            Level.fromExperience( 50 ).label == 'legend'
            Level.fromExperience( 100 ).label == 'god'

    }

    def "Cannot create 2 levels of the same point value"(){

        when:
            new Level( label: 'one', experience:10 ).save( validate: false )

        then:
            new Level( label: 'two', experience:10 ).validate() == false

    }

    def "experience below lowest level should return null"(){

        when:
            new Level( label: 'newbie', experience: 0 ).save( validate: false )

        then:
            Level.fromExperience( -20 ) == null

    }

    def "get next level"(){

        setup:
            setupLevels()

        expect:
            Level.nextLevel( -20 ).label == 'newbie'
            Level.nextLevel( 20 ).label == 'legend'
            Level.nextLevel( 51 ).label == 'god'
            Level.nextLevel( 99 ) == null

    }

    private setupLevels(){
        new Level( label: 'newbie', experience: 0 ).save( validate: false )
        new Level( label: 'legend', experience: 50 ).save( validate: false )
        new Level( label: 'god', experience: 99 ).save( validate: false )
    }

}