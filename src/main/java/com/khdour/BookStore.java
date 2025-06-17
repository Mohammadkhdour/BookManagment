package com.khdour;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

public class BookStore {
    private ArrayList<Book> books;

    public BookStore() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        if(searchByISBN(book.getISBN())!=null)return;
        this.books.add(book);
        System.out.println("Book added: Title: " + book.getTitle() +
                ", ISBN: " + book.getISBN() +
                ", Author: " + book.getAuthor() +
                ", Price: " + book.getPrice());

    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public ArrayList<Book> getBooks() {
        return this.books;
    }

    public Book searchByISBN(String ISBN) {
        for (Book book : books) {
            if (book.getISBN().equalsIgnoreCase(ISBN)) {
                System.out.println("Book found: " + book.toString());
                return book;
            }
        }
        System.out.println("book not found");
        return null;
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in the store.");
        } else {
            for (Book book : books) {
                System.out.println("book info: " + book.toString());
            }
        }
    }

    public void deleteByISBN(String ISBN) {
        Book book;
        if ((book = searchByISBN(ISBN)) != null) {
            books.remove(book);
            System.out.println("The book with ISBN " + ISBN + " has been deleted.");
        } else {
            System.out.println("The book with ISBN " + ISBN + " was not found and could not be deleted.");
        }

    }

    public void loadAllBooksFromCSV(String path) {
        books.clear();

        File file = new File(path);
        if (!file.exists()) {
            System.out.println("CSV file not found. Starting with an empty list.");
            return;
        }

        try (
                Reader reader = new FileReader(file);) {
            @SuppressWarnings("deprecation")
            CSVFormat format = CSVFormat.DEFAULT.builder()
                    .setHeader("isbn", "title", "author", "price") // define headers
                    .setSkipHeaderRecord(true)
                    .build();

            Iterable<CSVRecord> records = format.parse(reader);

            for (CSVRecord record : records) {
                String isbn = record.get("isbn");
                String title = record.get("title");
                String author = record.get("author");
                double price = Double.parseDouble(record.get("price"));

                books.add(new Book(isbn, title, author, price));
               // addBook(new Book(isbn, title, author, price));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void storeAllBooksToCSV(String filePath) {
        try (
                FileWriter writer = new FileWriter(filePath);
                @SuppressWarnings("deprecation")
                CSVPrinter csvPrinter = new CSVPrinter(writer,
                        CSVFormat.DEFAULT.withHeader("isbn", "title", "author", "price"));) {
            for (Book book : books) {
                csvPrinter.printRecord(book.getISBN(), book.getTitle(), book.getAuthor(), book.getPrice());
            }
            csvPrinter.flush();
            System.out.println("Saved " + books.size() + " books to CSV.");
        } catch (IOException e) {
            System.err.println("Error writing CSV file: " + e.getMessage());
        }
    }

}
