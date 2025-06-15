package com.dantedevfr.books_service.service.impl;

import com.dantedevfr.books_service.model.Book;
import com.dantedevfr.books_service.repository.BookRepository;
import com.dantedevfr.books_service.service.BookService;

import java.util.List;
import java.util.Optional;

public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAllValidBooks() {
        return List.of();
    }

    @Override
    public Optional<Book> getBookById(Long id) {
        return Optional.empty();
    }
}
