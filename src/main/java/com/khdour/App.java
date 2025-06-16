package com.khdour;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;

public class App {
    public static void main(String[] args) {
        BookStore bookStore = new BookStore();

         String filePath = "/Users/Apple/Desktop/University/training/BookManagment/src/main/java/com/khdour/bookstore.txt";
        readBooksFromFile(filePath, bookStore);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            menu();
            int choice = scanner.nextInt();
             scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    System.out.print("Enter ISBN: ");
                    String isbn = scanner.nextLine();
                    if ((bookStore.searchByISBN(isbn)) != null){
                        System.out.println("the ISBN is exist cann't be added");
                        continue;
                    }
                    else if(!isbn.matches("\\d{4}")){
                        System.out.println("the ISBN is cann't be added should be 4 digit");
                        continue;
                    }
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter Price: ");
                    double price = scanner.nextDouble();
                    bookStore.addBook(new Book(isbn, title, author, price));
                    System.out.println("Book added successfully.");
                    break;
                case 2:
                    System.out.print("Enter ISBN to search: ");
                    String searchISBN = scanner.nextLine();
                    bookStore.searchByISBN(searchISBN);
                    break;
                case 3:
                    bookStore.displayBooks();
                    break;
                case 4:
                    System.out.print("Enter ISBN to delete: ");
                    String deleteISBN = scanner.nextLine();
                    bookStore.deleteByISBN(deleteISBN);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    writeBooksToFile(filePath, bookStore);
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

    }

    public static void menu() {
            System.out.println("\nBook Store Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. Search Book by ISBN");
            System.out.println("3. Display All Books");
            System.out.println("4. Delete Book by ISBN");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
    }

    public static void readBooksFromFile(String filePath, BookStore bookStore) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String isbn = parts[0].trim();
                    String title = parts[1].trim();
                    String author = parts[2].trim();
                    double price = Double.parseDouble(parts[3].trim());
                    bookStore.addBook(new Book(isbn, title, author, price));
                }
            }
            System.out.println("Books loaded from file successfully.");
        } catch (Exception e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }

    public static void writeBooksToFile(String filePath, BookStore bookStore) {
        try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(filePath))) {
            for (Book book : bookStore.getBooks()) {
                writer.write(book.getISBN() + "," + book.getTitle() + "," + book.getAuthor() + "," + book.getPrice());
                writer.newLine();
            }
            System.out.println("Books saved to file successfully.");
        } catch (Exception e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
