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

	def "add a new movie title and see it in the list of movies"() {
		when:
		go()

		and:
		waitFor {  $("#addMovieNavButton").displayed  }

		and:
		$("#addMovieNavButton").click()

		then:
		title == "Front Row Reviews - Add Movie"

		when:
		$("input", id: "emailAddress").value("paul@movies.com")
		$("input", id: "title").value("Star Trek into darkness")
		$("textarea", id: "description").value("just brill!")

		// click add
		$("#addMovieBtn").click()

		then:
		waitFor {
            $("#addMovieStatus", text: startsWith("/rest/movie/")).size() == 1
		}

		// now get the list of movies and make sure that it is there
		when:
		waitFor {  $("#listMoviesNavButton").displayed  }
		
		and:
		$("#listMoviesNavButton").click()

		then:
		title == "Front Row Reviews - Movies"

		and:
		waitFor {
			$(".moviesTable").find("td").text() == "Star Trek into darkness"
		}
		
		// now create a review
        $("a", text: startsWith("Add Review")).click()
		
		then:
		title == "Front Row Reviews - Review Movie"
		
		when:
		$("textarea", id: "review").value("great film")

		// click add
		$("#addMovieReviewBtn").click()

		then:
		waitFor {
            $("#addReviewStatus", text: startsWith("/rest/review/")).size() == 1
		}
           
        // go back to the movie list page and make sure that the
        // review we just added is displayed
		when:
		waitFor {  $("#listMoviesNavButton").displayed  }
		
		and:
		$("#listMoviesNavButton").click()

		and:
        waitFor {  $("a", text: startsWith("Show Reviews")).displayed  }
  
        $("a", text: startsWith("Show Reviews")).click()
        
		then:
		waitFor {
            $("span", text: endsWith("great film")).size() == 1
		}

	}
}
