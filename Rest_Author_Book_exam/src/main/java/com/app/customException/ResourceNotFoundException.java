package com.app.customException;

public class ResourceNotFoundException extends RuntimeException {
	
	private String mgs;
	
	public ResourceNotFoundException(String mgs) {
		this.mgs=mgs;
	}

}
