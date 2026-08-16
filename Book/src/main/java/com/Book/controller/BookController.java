package com.Book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.Book.entity.Book;
import com.Book.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    // 1. Add Book
    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    // 2. Fetch all Books
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    // 3. Fetch all Programming Books
    @GetMapping("/programming")
    public List<Book> getProgrammingBooks() {
        return bookService.getProgrammingBooks();
    }

    // 4. Fetch all Java Books
    @GetMapping("/java")
    public List<Book> getJavaBooks() {
        return bookService.getJavaBooks();
    }

    // 5. Fetch Book by ID
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable int id) {
        return bookService.getBookById(id);
    }

    // 6. Fetch Books by Author
    @GetMapping("/author/{author}")
    public List<Book> getBooksByAuthor(@PathVariable String author) {
        return bookService.getBooksByAuthor(author);
    }

    // 7. Fetch highest price Book
    @GetMapping("/highest-price")
    public List<Book> getHighestPriceBooks() {
        return bookService.getHighestPriceBooks();
    }

    // 8. Fetch highest rating Book
    @GetMapping("/highest-rating")
    public List<Book> getHighestRatingBooks() {
        return bookService.getHighestRatingBooks();
    }

    // 9. Update Book price by ID
    @PutMapping("/{id}/price")
    public Book updatePrice(
            @PathVariable int id,
            @RequestParam double price) {

        return bookService.updatePrice(id, price);
    }

    // 10. Update Book rating by ID
    @PutMapping("/{id}/rating")
    public Book updateRating(
            @PathVariable int id,
            @RequestParam double rating) {

        return bookService.updateRating(id, rating);
    }

    // 11. Update Book category by ID
    @PutMapping("/{id}/category")
    public Book updateCategory(
            @PathVariable int id,
            @RequestParam String category) {

        return bookService.updateCategory(id, category);
    }

    // 12. Delete Book by ID
    @DeleteMapping("/{id}")
    public String deleteBookById(@PathVariable int id) {
        return bookService.deleteBookById(id);
    }

    // 13. Delete Books by Author
    @DeleteMapping("/author/{author}")
    public String deleteBooksByAuthor(@PathVariable String author) {
        return bookService.deleteBooksByAuthor(author);
    }

    // 14. Fetch top 3 highest rating Books
    @GetMapping("/top3-rating")
    public List<Book> getTop3HighestRatingBooks() {
        return bookService.getTop3HighestRatingBooks();
    }

    // 15. Fetch Premium Books
    @GetMapping("/premium")
    public List<Book> getPremiumBooks() {
        return bookService.getPremiumBooks();
    }
}