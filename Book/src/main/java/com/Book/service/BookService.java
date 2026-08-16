package com.Book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Book.entity.Book;
import com.Book.repository.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    // 1. Add Book
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    // 2. Get all Books
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // 3. Get Programming Books
    public List<Book> getProgrammingBooks() {
        return bookRepository.findByCategory("Programming");
    }

    // 4. Get Java Books
    public List<Book> getJavaBooks() {
        return bookRepository.findByNameContainingIgnoreCase("Java");
    }

    // 5. Get Book by ID
    public Book getBookById(int id) {
        return bookRepository.findById(id).orElse(null);
    }

    // 6. Get Books by Author
    public List<Book> getBooksByAuthor(String author) {
        return bookRepository.findByAuthorIgnoreCase(author);
    }

    // 7. Get highest price Book
    public List<Book> getHighestPriceBooks() {
        return bookRepository.findTopByOrderByPriceDesc();
    }

    // 8. Get highest rating Book
    public List<Book> getHighestRatingBooks() {
        return bookRepository.findTopByOrderByRatingDesc();
    }

    // 9. Update Book price
    public Book updatePrice(int id, double price) {

        Book book = bookRepository.findById(id).orElse(null);

        if (book == null) {
            return null;
        }

        book.setPrice(price);

        return bookRepository.save(book);
    }

    // 10. Update Book rating
    public Book updateRating(int id, double rating) {

        Book book = bookRepository.findById(id).orElse(null);

        if (book == null) {
            return null;
        }

        book.setRating(rating);

        return bookRepository.save(book);
    }

    // 11. Update Book category
    public Book updateCategory(int id, String category) {

        Book book = bookRepository.findById(id).orElse(null);

        if (book == null) {
            return null;
        }

        book.setCategory(category);

        return bookRepository.save(book);
    }

    // 12. Delete Book by ID
    public String deleteBookById(int id) {

        if (!bookRepository.existsById(id)) {
            return "Book not found";
        }

        bookRepository.deleteById(id);

        return "Book deleted successfully";
    }

    // 13. Delete Books by Author
    public String deleteBooksByAuthor(String author) {

        List<Book> books = bookRepository.findByAuthorIgnoreCase(author);

        if (books.isEmpty()) {
            return "No books found for author: " + author;
        }

        bookRepository.deleteAll(books);

        return "Books deleted successfully";
    }

    // 14. Top 3 highest rating Books
    public List<Book> getTop3HighestRatingBooks() {
        return bookRepository.findTop3ByOrderByRatingDesc();
    }

    // 15. Premium Books
    public List<Book> getPremiumBooks() {
        return bookRepository.findByPriceGreaterThan(1000);
    }
}