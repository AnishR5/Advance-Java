package pojos;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book extends BaseEntity {
	
	@Column(name = "book_title", length = 20,nullable = false,unique = true)
	private String title;
	@Column(nullable = false )
	private double price;
	@ManyToOne
	@JoinColumn(name = "author_id")
	private Author authorId;
	
	
	public Book(String title, double price) {
		super();
		this.title = title;
		this.price = price;
		
	}
	@Override
	public String toString() {
		return "Book [title=" + title + ", price=" + price + "]";
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Author getAuthorId() {
		return authorId;
	}
	public void setAuthorId(Author authorId) {
		this.authorId = authorId;
	}
	

}
