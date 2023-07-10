package com.app.service;

import java.util.List;

import com.app.dto.BookInsertDto;
import com.app.dto.BookUpdateDto;
import com.app.dto.ResponseDto;
import com.app.entity.Book;

public interface BookService {
	
	ResponseDto insertBook(BookInsertDto dto);
	
	List<Book> getAllBooks();
	
	List<Book> getBookByAuthorid(int authorId);
	
	ResponseDto updateBook(BookUpdateDto dto);

}
