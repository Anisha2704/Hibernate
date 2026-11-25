package library_mang;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Author {
	
	@Id
	private int id;
	
	private String name;
	
	private String bio;
	
	@Column(unique = true)
	private String email;
	
	@ManyToMany(mappedBy = "authors")
	private List<Book> books;

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

//	@Override
//	public String toString() {
//		return "Author [id=" + id + ", name=" + name + ", bio=" + bio + ", books=" + books + "]";
//	}

//	public Author(int id, String name, String bio) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.bio = bio;
//	}
	
	
	
	

}
