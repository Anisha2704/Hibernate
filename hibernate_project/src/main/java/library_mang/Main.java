package library_mang;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Main {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("library_management");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Scanner sc = new Scanner(System.in);
		
//		Member m1 = new Member(1, "Anisha", "ani@gmail",LocalDate.of(2026, 11, 13) );
//		Member m2 = new Member(2, "pranay", "pranu@gmail",LocalDate.of(2026, 10, 15) );	
//		
//		Author a1 = new Author(101, "Saniya", "I m a writer!" );
//		Author a2 = new Author(102, "Anisha", "I m a reader !");
//		
//		Book b1 = new Book(01, "Akansha-the stars", 2026, 5, Arrays.asList(a1,a2));
//		
//		a1.setBooks(Arrays.asList(b1));
//		a2.setBooks(Arrays.asList(b1));
		
//		***** Data entry *****
//		et.begin();
//		em.persist(m1);
//		em.persist(m2);
//		em.persist(a1);
//		em.persist(a2);
//		em.persist(b1);
//		et.commit();
//		em.close();
//		emf.close();
		
//		***** Retreiving data *****
//		getBooks(em);
//		getAuthors(em);
//		getMembers(em);
		
//		**** Issuing a Book *****
//		issueBook(em, et, sc, 1);
//		issueBook(em, et, sc, 2);
		
//		**** Returning a Book *****
//		returnBook(em, et, sc);
		
		
		// adding a member
//		addMember(sc, em, et);
		
		// adding a author
//		addAuthor(sc, em, et);

		
		
	}
	
	public static void addAuthor(Scanner sc, EntityManager em, EntityTransaction et) {
		
		Author a = new Author();
		
		System.out.println("Enter Details: ");
		System.out.println("Name: ");
		a.setName(sc.nextLine());
		System.out.println("Email: ");
		a.setEmail(sc.next());
		System.out.println("Bio: ");
		a.setBio(sc.nextLine());
		
		try {
			Query q =em.createQuery("select id from Author where email = ?1");
			
			q.setParameter(1, a.getEmail());
			System.out.println("Author exits! \n Author Id: " + q.getSingleResult());
		}catch(NoResultException e) {
			et.begin();
			em.persist(a);
			et.commit();
			System.out.println("Author added! \n Author Id: " + a.getId());
		}
		
	}
	
	public static void addBook(Scanner sc, EntityManager em, EntityTransaction et) {
		
		Book b = new Book();
		
		System.out.println("Enter Details: ");
		System.out.println("Title: ");
		b.setTitle(sc.nextLine());
		System.out.println("Publication Year: ");
		b.setPublicationYear(sc.nextInt());
		System.out.println("Available Copies: ");
		b.setAvailableCopies(sc.nextInt());
		
		System.out.println("want to add authors?(yes/no)");
		String choice = sc.next();
		
		List<Author> authors = null;
		
		if(choice.equalsIgnoreCase("yes")) {
			System.out.println("Available Authors");
			getAuthors(em);
			
			authors = new ArrayList<Author>();
		}
		
		while(choice.equalsIgnoreCase("yes")) {
			
			System.out.println("Enter Author id: ");
			int aid = sc.nextInt();
			
			Author a = em.find(Author.class, aid);
			
			if(a != null) {
				authors.add(a);
				System.out.println("Author added! ");
			}else {
				System.out.println("Author not found!");
			}
			
			System.out.println("want to add another author?(yes/no): ");
			choice = sc.next();
		}
		
		b.setAuthors(authors);
		
				
		try {
			Query q =em.createQuery("select id from Book where title = ?1");
			
			q.setParameter(1, b.getTitle());
			System.out.println("Author exits! \n Author Id: " + q.getSingleResult());
		}catch(NoResultException e) {
			et.begin();
			em.persist(b);
			et.commit();
			System.out.println("Author added! \n Author Id: " + b.getId());
		}
		
	}
	
	public static void addMember(Scanner sc,EntityManager em, EntityTransaction et) {
		
		Member m = new Member();
		
		System.out.println("Enter Your Details: ");
		
		System.out.println("Name:");
		m.setName(sc.nextLine());
		
		System.out.println("Email: ");
		m.setEmail(sc.next());
		
		m.setJoinDate(LocalDate.now());
		
		try {
			Query q =em.createQuery("select id from Member where email = ?1");
			q.setParameter(1, m.getEmail());
			System.out.println("Member Id: " + q.getSingleResult());
			System.out.println("Already a Member!");
		}catch(NoResultException e) {	
			et.begin();
			em.persist(m);
			et.commit();
			System.out.println("You are a member now!");
			System.out.println("Your member id is " + m.getId());
		}			
	}
	
	public static void getBooks(EntityManager em) {
		List<Book> allBooks = em.createQuery("from Book").getResultList();
		
		for(Book b : allBooks) {
			System.out.println(b);
		}
	}
	
	public static void getAuthors(EntityManager em) {
		List<Author> allAuthors = em.createQuery("from Author").getResultList();
		
		for(Author a : allAuthors) {
			System.out.println(a.getId()+ " " + a.getName() + " " + a.getBio() + " " + a.getBooks());
		}
	}
	
	public static void getMembers(EntityManager em) {
		List<Member> allMembers = em.createQuery("from Member").getResultList();
		
		for(Member m : allMembers) {
			System.out.println(m.getId() + " " + m.getEmail() + " " + m.getName() + " " + m.getJoinDate());
		}
	}
	
	public static void getRecords(EntityManager em) {
		List<BorrowRecord> allRecords = em.createQuery("FROM BorrowRecord").getResultList();
		
		for(BorrowRecord b : allRecords) {
			System.out.println(b.getId() + " " + b.getMember().getName() + " " + b.getBook().getTitle() +" " + b.getBorrowDate() + " " + b.getDueDate() + " " + b.getReturnDate() + " " + b.getFineAmount());
		}
	}
	
	public static void issueBook(EntityManager em, EntityTransaction et, Scanner sc) {
		System.out.print("What is your member id ?");
		int mid = sc.nextInt();
		
		System.out.print("Which book you want to issue? ");
		int bid = sc.nextInt();
		
		Member m = null;
		Book b = null;
		
		m = em.find(Member.class, mid);
		b = em.find(Book.class, bid);
			 
		if(m== null || b== null){
			System.out.println("Invalid member or book ID!");
		}
		
		
		if(m!=null && b!=null && b.getAvailableCopies()>0) {
			
			BorrowRecord br = new BorrowRecord();
			br.setBorrowDate(LocalDate.now());	
			br.setDueDate(br.getBorrowDate().plusDays(7));
			br.setBook(b);
			br.setMember(m);
			
			b.setAvailableCopies(b.getAvailableCopies()-1);
			
			et.begin();
			em.persist(br);
			et.commit();
			
			System.out.println("Book issued! ");
		}
		else {
			System.out.println("Book is not available now.");
		}
	}
	
	public static void returnBook(EntityManager em, EntityTransaction et, Scanner sc) {
		System.out.print("What is your member id ?");
		int mid = sc.nextInt();
		
		System.out.print("Which book you want to return? ");
		int bid = sc.nextInt();
		
		Member m = null;
		Book b = null;
		
		m = em.find(Member.class, mid);
		b = em.find(Book.class, bid);
			 
		if(m== null || b== null){
			System.out.println("Invalid member or book ID!");
		}
		else {
		Query q = em.createQuery("select br.id from BorrowRecord br where br.book=?1 AND br.member=?2");
		q.setParameter(1, b);
		q.setParameter(2, m);
		
		Object brId = q.getSingleResult();

		BorrowRecord br = em.find(BorrowRecord.class, brId);
		
			if(br.getReturnDate() != null) {
				System.out.println("Book already returned! ");
			}
			else {
				
				br.setReturnDate(LocalDate.now());
				
				int diff = (br.getReturnDate().compareTo(br.getDueDate()));
				
				if(diff > 0) {
					br.setFineAmount(diff*5);
				}
				else {
					br.setFineAmount(0);
				}
				
				if(br.getFineAmount()!=0) {
					System.out.println("your fine is : "+ br.getFineAmount());
				}
				
				b.setAvailableCopies(b.getAvailableCopies() + 1);
				
				et.begin();
				et.commit();
				
				System.out.println("Book Returned ! ");
			}
		
		}

	}

}
