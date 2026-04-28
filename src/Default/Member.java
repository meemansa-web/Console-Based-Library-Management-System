package Default;

import java.time.LocalDate;
import java.util.HashMap;

public class Member {

    private String memberId;
    private String name;
    private HashMap<String, LocalDate> borrowedBooks;

    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        this.borrowedBooks = new HashMap<>();
    }

    public String getId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public HashMap<String, LocalDate> getBorrowedBooks() {
        return borrowedBooks;
    }

    // ✅ Borrow book with date
    public void borrowBook(String isbn) {
        borrowedBooks.put(isbn, LocalDate.now());
    }

    // ✅ Return book
    public LocalDate returnBook(String isbn) {
        return borrowedBooks.remove(isbn);
    }
    @Override
    public String toString() {
        return memberId + "," + name + "," + borrowedBooks.keySet();
    }
}