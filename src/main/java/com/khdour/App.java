package com.khdour;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        BookStore bookStore = new BookStore();
         String filePath = "books.csv";
         bookStore.loadAllBooksFromCSV(filePath);
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
                    bookStore.storeAllBooksToCSV(filePath);

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

}
