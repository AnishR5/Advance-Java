package com.app.entity;

import java.time.LocalDate;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "book")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Book extends BaseEntity {
	
	@Column(nullable = false)
	private String title;
	@Enumerated(EnumType.STRING)
	private Category category;
	@Column(nullable = false)
	private LocalDate publishDate;
	@Column(nullable = false)
	private double price;
	@ManyToOne
	@JoinColumn(name = "authorId",nullable = false)
	private Author authorId;
	public Book(String title, Category category, LocalDate publishDate, double price) {
		super();
		this.title = title;
		this.category = category;
		this.publishDate = publishDate;
		this.price = price;
	}
	
	public int getAuthorId()
	{
		return authorId.getId();
	}
	
	

}
