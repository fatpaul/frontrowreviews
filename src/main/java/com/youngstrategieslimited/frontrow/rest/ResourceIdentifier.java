package com.youngstrategieslimited.frontrow.rest;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ResourceIdentifier {

	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
