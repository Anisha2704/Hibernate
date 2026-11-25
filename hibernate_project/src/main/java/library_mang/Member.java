package library_mang;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Member {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	
	@Column(unique = true)
	private String email;
	
	private LocalDate joinDate;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(LocalDate joinDate) {
		this.joinDate = joinDate;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", email=" + email + ", joinDate=" + joinDate + "]";
	}

//	public Member(int id, String name, String email, LocalDate joinDate) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.email = email;
//		this.joinDate = joinDate;
//	}
	
	

	
}
