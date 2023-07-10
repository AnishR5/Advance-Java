package com.app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "author")
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = "bookList")
public class Author extends BaseEntity {
	
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String city;
	@Column(nullable = false)
	private String mobileNum;
	@OneToMany(mappedBy = "authorId",cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER)
	private List<Book> bookList=new ArrayList<Book>();
	public Author(String name, String city, String mobileNum) {
		super();
		this.name = name;
		this.city = city;
		this.mobileNum = mobileNum;
	}
	
	public void insertBook(Book book){
		bookList.add(book);
		book.setAuthorId(this);
	}
	
	public void update(Book book)
	{
		bookList.remove(book);
		insertBook(book);
	}
	
	

}
