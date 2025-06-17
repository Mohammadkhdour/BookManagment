package com.khdour;

public class Book{
    private String ISBN;
    private String Title;
    private String Author;
    private double price;
    

    public Book(String ISBN, String Title, String Author, double price){
        this.ISBN = ISBN;
        this.Title = Title;
        this.Author = Author;
        this.price = price;

    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String Author) {
        this.Author = Author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Book)) return false;
        Book other = (Book) obj;
        return ISBN.equals(other.ISBN) &&
               Title.equals(other.Title) &&
               Author.equals(other.Author) &&
               price == other.price;
    }
    
    @Override
    public String toString() {
        return "Book{" +
                "ISBN='" + ISBN + '\'' +
                ", Title='" + Title + '\'' +
                ", Author='" + Author + '\'' +
                ", price=" + price +
                '}';
    }
}