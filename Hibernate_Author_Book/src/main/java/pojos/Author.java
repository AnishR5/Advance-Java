package pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "authors")
public class Author extends BaseEntity {
	
	
	@Column(name = "first_name", length = 20, nullable = false)
	private String fname;
	@Column(name = "last_name" , length = 20, nullable = false)
	private String lname;
	@Column(length = 30 , unique = true , nullable = false)
	private String email;
	@Column(length = 20, nullable = false)
	private String password;
	@OneToMany(mappedBy = "authorId" , cascade = CascadeType.ALL)
	private List<Book> booklist=new ArrayList<Book>();
	
	public Author(String fname, String lname, String email, String password) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.password = password;
	}
	
	public Author() {
		// TODO Auto-generated constructor stub
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Book> getBooklist() {
		return booklist;
	}

	public void setBooklist(List<Book> booklist) {
		this.booklist = booklist;
	}
	
	public void addBook(Book b) {
		booklist.add(b);
		b.setAuthorId(this);
		
	}
	
	

}
