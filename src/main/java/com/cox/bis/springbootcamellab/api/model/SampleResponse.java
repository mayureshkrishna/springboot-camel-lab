package com.cox.bis.springbootcamellab.api.model;


import java.io.Serializable;

public class SampleResponse implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7981124347136945658L;
	private String name;
	
	public SampleResponse() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	


}