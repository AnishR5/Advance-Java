package com.app.dto;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthorInsertDto {
	
	@NotBlank
	private String name;
	@NotBlank
	private String city;
	@NotBlank
	private String mobileNum;

}
