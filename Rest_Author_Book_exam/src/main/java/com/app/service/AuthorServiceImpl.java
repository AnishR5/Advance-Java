package com.app.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.AuthorInsertDto;
import com.app.dto.ResponseDto;
import com.app.entity.Author;
import com.app.repository.AuthorRepository;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {
	
	public AuthorServiceImpl() {
		System.out.println("AuthorService stared");
	}
	
	@Autowired
	private AuthorRepository authorRepo;
	@Autowired
	private ModelMapper mapper;

	@Override
	public ResponseDto addAuthor(AuthorInsertDto dto) {
		Author auth=mapper.map(dto, Author.class);
		authorRepo.save(auth);
		return new ResponseDto("Author Added");
	}

	@Override
	public List<Author> getAllAuthors() {
		
		return authorRepo.findAll();
	}

}
