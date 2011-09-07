package grails.plugin.gamify

import grails.plugin.spock.*

class LevelSpec extends UnitSpec {

    def setup(){
        mockDomain( Level )
    }

    def "levels convert to the highest point threshold"() {

        when:
            new Level( label: 'newbie', experience: 0 ).save( validate: false )
            new Level( label: 'legend', experience: 50 ).save( validate: false )
            new Level( label: 'god', experience: 75 ).save( validate: false )

        then:
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

}