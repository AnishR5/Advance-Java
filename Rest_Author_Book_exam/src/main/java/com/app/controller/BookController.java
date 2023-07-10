package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.BookInsertDto;
import com.app.dto.BookUpdateDto;
import com.app.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
	
	public BookController() {
		System.out.println("Book controller started");
	}
	
	@Autowired
	private BookService bookService;
	
	@PostMapping("/addBook")
	public ResponseEntity<?> insertBook(@RequestBody BookInsertDto dto)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(bookService.insertBook(dto));
	}
	
	@GetMapping
	public ResponseEntity<?> getAllBooks()
	{
		return  ResponseEntity.status(HttpStatus.OK).body(bookService.getAllBooks()) ;
	}
	
	@GetMapping("/{authorId}")
	public ResponseEntity<?> getBookByAuthor(@PathVariable int authorId)
	{
		return ResponseEntity.status(HttpStatus.OK).body(bookService.getBookByAuthorid(authorId));
	}
	
	@PutMapping("/updateBook")
	public ResponseEntity<?> updateBook(@RequestBody BookUpdateDto dto)
	{
		return ResponseEntity.status(HttpStatus.OK).body(bookService.updateBook(dto));
	}
	
	

}
