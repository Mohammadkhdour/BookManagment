
# 📚 Bookstore Management System

## Overview

The **Bookstore Management System** is a Java-based console application designed to manage a collection of books. This project applies key object-oriented programming principles and demonstrates core Java skills including class design, object manipulation, and simple data handling. It allows users to perform basic bookstore operations such as adding, searching, displaying, and deleting books. The application uses Maven for build and dependency management and includes unit testing with JUnit.

## ✨ Features

- Persistent data storage using CSV files
- Add new books with ISBN, title, author, and price
- Search for books by ISBN
- Display all available books
- Delete books from the system
- Simple and intuitive console interface
- Unit tests to validate core functionality
- Managed and built using Maven

## 📁 Project Structure

```
bookstore-project/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/khdour/
│   │           ├── App.java          # Entry point of the application
│   │           ├── Book.java         # Book entity with attributes and methods
│   │           └── BookStore.java    # Book management logic
│   └── test/
│       └── java/
│           └── com/khdour/
│               └── AppTest.java      # Unit tests for BookStore functionality
├── pom.xml                           # Maven configuration file
├── .gitignore                        # Git ignored files and folders
└── README.md                         # Project documentation
```

## 🚀 Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Apache Maven

### Clone and Run

To build and run the project:

```bash
git clone https://github.com/yourusername/BookManagment.git
cd BookManagment
mvn compile
mvn exec:java
```

### Run Tests

JUnit tests are included to validate the core functionality. Run the tests with:

```bash
mvn test
```

### Example Test Method

```java
@Test
public void searchBookwithIBN1211() {
    BookStore store = new BookStore();
    Book book1211 = new Book("1211", "hello", "khdour", 20);
    store.addBook(book1211);
    Book searched = store.searchByISBN("1211");
    assertEquals(book1211, searched);
}
```

This test checks if a book added with ISBN "1211" can be found using the search functionality.
assertEquals use ovarride equal function from book class.


## 📝 License

This project is open-source and available under the MIT License. You are free to use, modify, and distribute this software with proper attribution.
