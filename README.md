# 📚 Hibernate Library Management System

A Java-based Library Management System developed using **Hibernate ORM, Jakarta Persistence (JPA), and PostgreSQL**. This project focuses on understanding Hibernate concepts through practical implementation, including entity mapping, relationship management, database operations, JPQL queries, transaction management, and dirty checking.

The application manages books, authors, library members, and borrowing records while handling book availability, return dates, and overdue fines.

## 🚀 Features

- **Author Management:** Add and retrieve author records.
- **Book Management:** Store book details and manage available copies.
- **Member Management:** Maintain library member information.
- **Book Issuing:** Issue books to registered members and create borrowing records.
- **Book Returning:** Process book returns and update availability.
- **Due Date Management:** Automatically calculate a due date of 7 days from the issue date.
- **Fine Calculation:** Calculate overdue fines based on the number of days after the due date.
- **Database Relationship Management:** Maintain associations between authors, books, members, and borrowing records.
- **Transaction Management:** Ensure database operations are performed within transactions.

## 🛠️ Technologies Used

| Technology | Purpose |
|---|---|
| Java | Programming language |
| Hibernate ORM | Object-relational mapping |
| Jakarta Persistence (JPA) | Persistence specification |
| PostgreSQL | Relational database |
| Maven | Dependency management |
| Eclipse IDE | Development environment |

## 📂 Project Structure

```text
hibernate_project/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── library_mang/
│   │   │       ├── Author.java
│   │   │       ├── Book.java
│   │   │       ├── Member.java
│   │   │       ├── BorrowRecord.java
│   │   │       └── Main.java
│   │   │
│   │   └── resources/
│   │       └── META-INF/
│   │           └── persistence.xml
│   │
│   └── test/
│
├── pom.xml
└── .gitignore
```

## 🗄️ Database Entities

The application consists of four main entities:

### 1. Author
Stores author information and maintains relationships with books.

### 2. Book
Stores book details, including book information and available copies.

### 3. Member
Stores library member information and maintains borrowing records.

### 4. BorrowRecord
Maintains the borrowing history, including:
- Issue date
- Due date
- Return date
- Associated book
- Associated member

## 🔗 Entity Relationships

| Relationship | Mapping |
|---|---|
| Author ↔ Book | `@ManyToMany` |
| Member → BorrowRecord | `@OneToMany` |
| BorrowRecord → Member | `@ManyToOne` |
| Book → BorrowRecord | `@OneToMany` |
| BorrowRecord → Book | `@ManyToOne` |

These mappings demonstrate how Hibernate manages relationships between Java objects and relational database tables.

## 📖 Hibernate & JPA Concepts Implemented

This project provides practical exposure to the following concepts:

### 1. ORM (Object Relational Mapping)
- Understanding the relationship between Java objects and database tables.
- Mapping entity classes to database tables.
- Mapping class properties to table columns.

### 2. JPA Annotations
- `@Entity`
- `@Table`
- `@Id`
- `@GeneratedValue`
- `@Column`
- `@ManyToMany`
- `@OneToMany`
- `@ManyToOne`
- `@JoinTable`
- `@JoinColumn`

### 3. EntityManager

Working with JPA's `EntityManager` to interact with the persistence context and database.

Methods explored:
- `persist()`
- `find()`
- `createQuery()`

### 4. EntityTransaction

Managing database transactions using:
- `begin()`
- `commit()`
- `rollback()`

### 5. JPQL (Java Persistence Query Language)
- Writing object-oriented database queries.
- Retrieving records using entity names and Java property names.
- Using aliases in queries.
- Using positional parameters such as `?1` and `?2`.
- Retrieving records based on specific conditions.

### 6. Entity Relationships
- One-to-Many mapping.
- Many-to-One mapping.
- Many-to-Many mapping.
- Managing bidirectional relationships.
- Understanding the owning side of a relationship.
- Understanding `mappedBy` and relationship management.

## 🎯 Learning Objectives

The primary objective of this project is to understand how Hibernate works internally and how JPA simplifies database interactions in Java applications.

Rather than relying only on theoretical concepts, this project explores their practical implementation through a real-world Library Management System.

---

**Repository:** [Hibernate – Library Management System](https://github.com/Anisha2704/Hibernate)
