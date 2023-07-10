package com.app.service;

import java.util.List;

import com.app.dto.AuthorInsertDto;
import com.app.dto.ResponseDto;
import com.app.entity.Author;

public interface AuthorService {
	
	ResponseDto addAuthor(AuthorInsertDto dto);
	
	List<Author> getAllAuthors();

}
