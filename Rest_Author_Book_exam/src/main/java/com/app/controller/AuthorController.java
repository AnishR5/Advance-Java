package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AuthorInsertDto;
import com.app.entity.Author;
import com.app.service.AuthorService;

@RestController
@RequestMapping("/authors")
public class AuthorController {
	
	public AuthorController() {
		System.out.println("Author Controller stared");
	}
	
	@Autowired
	private AuthorService authorService;
	
	@PostMapping("/addAuthor")
	public ResponseEntity<?> addAuthor(@RequestBody  @Valid AuthorInsertDto dto)
	{
		return ResponseEntity.status(HttpStatus.OK).body(authorService.addAuthor(dto));
	}
	
	@GetMapping
	public ResponseEntity<?> getAllAuthors()
	{
		return ResponseEntity.status(HttpStatus.OK).body(authorService.getAllAuthors());
	}
	

}
