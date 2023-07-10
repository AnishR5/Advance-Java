package com.app.dto;

import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;

import com.app.entity.Category;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookInsertDto {
	
	@NotBlank
	private String title;	
	@NotBlank
	private Category category;	
	@Future
	private LocalDate publishDate;
	private double price;
	private int authorId;

}
