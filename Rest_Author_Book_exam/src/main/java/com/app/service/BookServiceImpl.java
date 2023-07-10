package com.app.service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.List;import java.util.stream.Collector;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.customException.ResourceNotFoundException;
import com.app.dto.BookInsertDto;
import com.app.dto.BookUpdateDto;
import com.app.dto.ResponseDto;
import com.app.entity.Author;
import com.app.entity.Book;
import com.app.repository.AuthorRepository;
import com.app.repository.BookRepository;

@Service
@Transactional
public class BookServiceImpl implements BookService {
	
	public BookServiceImpl() {
		System.out.println("BookService stared");
	}
	
	@Autowired
	private BookRepository bookRepo;
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private AuthorRepository authorRepo;
	
	
	@Override
	public ResponseDto insertBook(BookInsertDto dto) {
		Book book=mapper.map(dto, Book.class);
		Author author=authorRepo.findById(dto.getAuthorId()).orElseThrow(()->new ResourceNotFoundException("Invalid Author id"));
		if(book.getPublishDate().isAfter(LocalDate.now()))
		{
			author.insertBook(book);
			bookRepo.save(book);
			return new ResponseDto("Book added succesfully");
		}	
		return new ResponseDto("Book not added");
	}


	@Override
	public List<Book> getAllBooks() {
		List<Book> list=bookRepo.findAll();
		//list.stream().sorted((e1,e2)->(e1.getCategory().compareTo(e2.getCategory()))).collect();
		return list;
	}


	@Override
	public List<Book> getBookByAuthorid(int authorId) {
		Author author=authorRepo.findById(authorId).orElseThrow(()-> new ResourceNotFoundException("Invalid Author id"));
		List<Book> list=bookRepo.findByAuthorId(author);
		return list;
	}


	@Override
	public ResponseDto updateBook(BookUpdateDto dto) {
		Book book=bookRepo.findById(dto.getBookId()).orElseThrow(()->new ResourceNotFoundException("invalid Book id"));
		book.setPrice(dto.getPrice());
		book.setPublishDate(dto.getPublishDate());
		Author author=authorRepo.findById(dto.getAuthorId()).orElseThrow(()->new ResourceNotFoundException("Invalid Author id"));
		if(book.getPublishDate().isAfter(LocalDate.now()))
		{
			author.update(book);
			bookRepo.save(book);
			return new ResponseDto("Book updated");
		}	
		return new ResponseDto("Book not updated");
	}


	
}
