package library_mang;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity
public class Book {
	
	@Id
	private int id;
	
	private String title;
	
	private int publicationYear;
	
	private int availableCopies;
	
	@ManyToMany
	private List<Author> authors;

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}

	public int getAvailableCopies() {
		return availableCopies;
	}

	public void setAvailableCopies(int availableCopies) {
		this.availableCopies = availableCopies;
	}

//	public Book(int id, String title, int publicationYear, int availableCopies, List<Author> authors) {
//		super();
//		this.id = id;
//		this.title = title;
//		this.publicationYear = publicationYear;
//		this.availableCopies = availableCopies;
//		this.authors = authors;
//	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", publicationYear=" + publicationYear + ", availableCopies="
				+ availableCopies + ", authors=" + authors + "]";
	}
	
	
	
	
	

}
