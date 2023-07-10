package com.app.dto;

import java.time.LocalDate;

import com.app.entity.Author;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookUpdateDto {
	
	private int bookId;
	private LocalDate publishDate;	
	private double price;
	private int authorId;

}
