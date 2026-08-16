package com.Book.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Book.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findByCategory(String category);

    List<Book> findByNameContainingIgnoreCase(String name);

    List<Book> findByAuthorIgnoreCase(String author);

    List<Book> findTopByOrderByPriceDesc();

    List<Book> findTopByOrderByRatingDesc();

    List<Book> findTop3ByOrderByRatingDesc();

    List<Book> findByPriceGreaterThan(double price);
}