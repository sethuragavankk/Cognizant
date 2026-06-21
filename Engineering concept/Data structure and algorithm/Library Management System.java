class Book {

    int bookId;
    String title;
    String author;

    Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public String toString() {
        return "Book ID: " + bookId +
               ", Title: " + title +
               ", Author: " + author;
    }
}

public class Main {

    // Linear Search
    public static Book linearSearch(Book[] books, String key) {

        for (int i = 0; i < books.length; i++) {

            if (books[i].title.equalsIgnoreCase(key)) {
                return books[i];
            }
        }

        return null;
    }

    // Binary Search
    public static Book binarySearch(Book[] books, String key) {

        int low = 0;
        int high = books.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            int result = books[mid].title.compareToIgnoreCase(key);

            if (result == 0) {
                return books[mid];
            }
            else if (result > 0) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return null;
    }

    public static void main(String[] args) {

        // Must be sorted by title for Binary Search
        Book[] books = {
            new Book(101, "Algorithms", "Thomas Cormen"),
            new Book(102, "Database Systems", "Elmasri"),
            new Book(103, "Java Programming", "Herbert Schildt"),
            new Book(104, "Operating Systems", "Galvin"),
            new Book(105, "Python Basics", "Mark Lutz")
        };

        String searchTitle = "Java Programming";

        System.out.println("Linear Search:");

        Book book1 = linearSearch(books, searchTitle);

        if (book1 != null)
            System.out.println(book1);
        else
            System.out.println("Book Not Found");

        System.out.println("\nBinary Search:");

        Book book2 = binarySearch(books, searchTitle);

        if (book2 != null)
            System.out.println(book2);
        else
            System.out.println("Book Not Found");
    }
}