import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

    private static BookManager library = new Library();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            printMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    testOriginalWorkflow();
                    break;
                case 2:
                    addNewBook();
                    break;
                case 3:
                    findBooksByAuthor();
                    break;
                case 4:
                    sortBooks();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close(); 
    }

    private static void printMenu() {
        System.out.println("\n--- Library Menu ---");
        System.out.println("1. Test Basic Functionality");
        System.out.println("2. Add New Book");
        System.out.println("3. Find Books by Author");
        System.out.println("4. Sort Books by Title");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private static int getUserChoice() {
        int choice = -1;
        try {
            choice = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next();
        }
        return choice;
    }

    private static void testOriginalWorkflow() {
        System.out.println("\n--- Testing Bas ---");
        
        // Clear the current list before adding test books
        library.getBooks().clear(); 
        System.out.println("(Library cleared before adding test set)");

        // Add books (original set)
        library.addBook(new Book("Your Lie in April", "Spiegelin", 2011));
        library.addBook(new Book("Hunter x Hunter", "Feiner", 1998));
        library.addBook(new Book("Hero X", "Daniel Cisneros", 2015));
        library.addBook(new Book("Mario Tennis", "Diego Esparza", 2000));
        library.addBook(new Book("Brr Brr Patapum", "Chen Li", 2022));
        library.addBook(new Book("Another Story", "Feiner", 2005));

        System.out.println("\n--- All Books (After adding test set) ---");
        library.printAllBooks();
        System.out.println("-----------------------------------");

        String authorToFind = "Feiner";
        System.out.println("\n--- Finding Books by " + authorToFind + " ---");
        List<Book> booksByAuthor = library.findBooksByAuthor(authorToFind);
        if (booksByAuthor.isEmpty()) {
             System.out.println("No books found by " + authorToFind);
        } else {
             booksByAuthor.forEach(System.out::println);
        }
        System.out.println("-----------------------------------");

        System.out.println("\n--- Sorting All Books by Title ---");
        library.sortBooksByTitle();
        library.printAllBooks();
        System.out.println("-----------------------------------");
        System.out.println("--- Original Workflow Test Complete ---");
    }

    private static void addNewBook() {
        scanner.nextLine();
        System.out.println("\n--- Add New Book ---");
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        int year = 0;
        boolean validYear = false;
        while (!validYear) {
            System.out.print("Enter publication year: ");
            try {
                year = scanner.nextInt();
                validYear = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid year. Please enter a number.");
                scanner.next();
            }
        }

        library.addBook(new Book(title, author, year));
        System.out.println("Book added successfully!");
    }

    private static void findBooksByAuthor() {
        scanner.nextLine(); 
        System.out.println("\n--- Find Books by Author ---");
        System.out.print("Enter author name: ");
        String author = scanner.nextLine();

        List<Book> foundBooks = library.findBooksByAuthor(author);

        if (foundBooks.isEmpty()) {
            System.out.println("No books found by " + author + ".");
        } else {
            System.out.println("Found books:");
            foundBooks.forEach(System.out::println);
        }
    }

    private static void sortBooks() {
        System.out.println("\n--- Sorting Books by Title ---");
        library.sortBooksByTitle();
        System.out.println("Books sorted successfully. Current list:");
        library.printAllBooks();
    }
} 