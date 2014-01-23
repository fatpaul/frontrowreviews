package com.youngstrategieslimited.frontrow.rest;

import javax.xml.bind.annotation.XmlRootElement;

import com.youngstrategieslimited.frontrow.core.movie.Movie;

@XmlRootElement
public class MovieViewModel {

	private String title;
	private String description;

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

	public void setDescription(String description) {
		this.description = description;
	}

	public Movie createDomainModel() {
		return new Movie(title, description);
	}

}
