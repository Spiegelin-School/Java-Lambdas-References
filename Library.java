import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Library implements BookManager {

    private List<Book> books = new ArrayList<>(); // Instance variable for books

    @Override
    public void addBook(Book book) {
        this.books.add(book);
    }

    @Override
    public List<Book> getBooks() {
        return this.books; // Return the instance list
    }

    @Override
    public List<Book> findBooksByAuthor(String author) {
        // Using a Lambda expression to filter books by author
        return this.books.stream()
                    .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                    .collect(Collectors.toList());
    }

    @Override
    public List<Book> sortBooksByTitle() {
        // Modified to, instead of using .sorted(), use .sort() to sort the original list
        this.books.sort((b1, b2) -> b1.getTitle().compareTo(b2.getTitle())); 
        return this.books;
    }
} 