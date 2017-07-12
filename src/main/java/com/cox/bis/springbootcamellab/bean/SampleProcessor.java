package com.cox.bis.springbootcamellab.bean;

import org.springframework.stereotype.Component;

import com.cox.bis.springbootcamellab.api.model.SampleResponse;

@Component("sampleProcessor")
public class SampleProcessor {

	/***
	 * Method: Sample Description:
	 * within parameters
	 * 

	 */


	public SampleResponse getName(String firstName, String lastName) throws Exception {

		SampleResponse response = new SampleResponse();
		return response;
	}

	public String ping() {

		String response = "success";
		return response;

	}
}