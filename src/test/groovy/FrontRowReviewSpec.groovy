import geb.spock.GebReportingSpec

import spock.lang.*

@Stepwise
class FrontRowReviewSpec extends GebReportingSpec {
    
    def "go to front row reviews home page and check core details"() {
        when:
        go()

        then:
        title == "Front Row Reviews"
    }
    
        def "add a new movie title"() {
        when:
        	go()
        
        and:
        	waitFor { $("a.addMovieButton").displayed }
        
  		and:
        	$("a.addMovieButton").click()

        then:
        	title == "Front Row Reviews - Add Movie"
        
        when:
     	   	// set title/description
       		$("input", id: "title").value("Star Trek into darkness")
        	$("textarea", id: "description").value("just brill!")
        
        	// click add
        	$("#addMovieBtn").click()
        
        then:
        	waitFor { $("#addMovieStatus").text() == "Movie saved : Star Trek into darkness - just brill!" }
    }
}
