package baitapSlot04Bai01;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LibraryManager {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> searchBooks(String title, String author, String publisher, String genre) {
        return books.stream().filter(book -> book.getTitle().contains(title) && 
                                              book.getAuthor().contains(author))
                             .collect(Collectors.toList());
    }

    public void borrowBook(String title, String studentId) {
        books.stream()
             .filter(book -> book.getTitle().equals(title) && book.getStatus().equals("Available"))
             .findFirst()
             .ifPresent(book -> book.setStatus("Borrowed by " + studentId));
    }

    public List<Book> getBooksBorrowedByStudent(String studentId) {
        return books.stream()
                    .filter(book -> book.getStatus().contains(studentId))
                    .collect(Collectors.toList());
    }
}

