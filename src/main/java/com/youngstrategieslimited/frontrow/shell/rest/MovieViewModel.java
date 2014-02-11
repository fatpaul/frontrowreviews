package com.youngstrategieslimited.frontrow.shell.rest;

import javax.xml.bind.annotation.XmlRootElement;

import com.youngstrategieslimited.frontrow.core.movie.Movie;

@XmlRootElement
public class MovieViewModel {

	private String title = "";
	private String description = "";
    private String key="";
    private String urlToReviews = "";

	public MovieViewModel(Movie movie) {
		this.description = movie.getDescription();
		this.title = movie.getTitle();
        
        // TODO: this isnt good, null checks - use double dispatch
        if(movie.getKey() != null){
            this.key = movie.getKey().appendKeyTo(this.key);
            this.urlToReviews = movie.getKey().appendKeyTo("rest/review/");
        }
	}

	public MovieViewModel() {
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}
   
    public void setKey(String key){
        this.key = key;
    }
 
    public String getKey(){
        return key;
    }

	public void setDescription(String description) {
		this.description = description;
	}

	public Movie createDomainModel() {
		return new Movie(title, description);
	}

    public String getUrlToReviews() {
        return urlToReviews;
    }

    public void setUrlToReviews(String urlToReviews) {
        this.urlToReviews = urlToReviews;
    }
}
