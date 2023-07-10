package com.app.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDto {
	
	private String mgs;
	
	public ResponseDto(String mgs) {
		this.mgs=mgs;
	}

}
