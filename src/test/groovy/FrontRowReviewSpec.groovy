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
			$("#addMovieStatus").text() == "/rest/movie/Star Trek into darkness"
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
		$("#addReview_Star_Trek_into_darkness").click()
		
		then:
		title == "Front Row Reviews - Review Movie"
		
		when:
		$("textarea", id: "review").value("great film")

		// click add
		$("#addMovieReviewBtn").click()

		then:
		waitFor {
			$("#addReviewStatus").text() == "/rest/review/1"
		}

	}
}
