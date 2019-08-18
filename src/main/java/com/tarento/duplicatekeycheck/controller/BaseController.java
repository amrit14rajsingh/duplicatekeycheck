package com.tarento.duplicatekeycheck.controller;


import com.tarento.duplicatekeycheck.domain.ApplicationResponse;
import com.tarento.duplicatekeycheck.util.ApplicationConstants;

public abstract class BaseController {
	
	
	public ApplicationResponse getServerResponse(int responseCode, Object data){
		ApplicationResponse applicatioResponse = new ApplicationResponse();
		applicatioResponse.setStatusCode(responseCode);
		applicatioResponse.setData(data);
		addMessage(responseCode,applicatioResponse);
		return applicatioResponse; 
	}
   
	public void addMessage(int responseCode, ApplicationResponse applicatioResponse) {
		
		switch (responseCode) {
		
		case 201:
		    applicatioResponse.setResponseMessage(ApplicationConstants.DUPLICATEFALSE);
		    break;
		case 200:
			applicatioResponse.setResponseMessage(ApplicationConstants.DUPLICATETRUE);
		    break;
		}
	}
	
}
