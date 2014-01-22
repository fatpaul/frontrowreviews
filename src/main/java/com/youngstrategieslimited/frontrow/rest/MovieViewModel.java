package com.youngstrategieslimited.frontrow.rest;

import javax.xml.bind.annotation.XmlRootElement;

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

}
