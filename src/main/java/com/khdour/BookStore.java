package com.khdour;
import java.util.ArrayList;

public class BookStore {
    private ArrayList <Book> books;

    public BookStore(){
        this.books = new ArrayList<>();
    }
    public void addBook(Book book){
        this.books.add(book);
        System.out.println("Book added: Title: " + book.getTitle() + 
                           ", ISBN: " + book.getISBN() + 
                           ", Author: " + book.getAuthor() + 
                           ", Price: " + book.getPrice());

    }

    public ArrayList<Book> getBooks(){
        return this.books;
    }

    public Book searchByISBN(String ISBN){
            for ( Book book : books){
            if(book.getISBN().equalsIgnoreCase(ISBN)){
                System.out.println("Book found: " + book.toString());
                return book;
            }
        }
            System.out.println("book not found");
            return null;
    }

    public void displayBooks(){
         if (books.isEmpty()) {
            System.out.println("No books available in the store.");
        } else {
        for (Book book : books) {
            System.out.println("book info: "+ book.toString());
        }
    }
    }

    public void deleteByISBN(String ISBN){
        Book book;
        if((book = searchByISBN(ISBN))!= null){
            books.remove(book);
            System.out.println("The book with ISBN " + ISBN + " has been deleted.");
        }
         else {
                System.out.println("The book with ISBN " + ISBN + " was not found and could not be deleted.");
         }
        
    }

    

}
