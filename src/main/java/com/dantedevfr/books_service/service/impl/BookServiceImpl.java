package com.dantedevfr.books_service.service.impl;

import com.dantedevfr.books_service.model.Book;
import com.dantedevfr.books_service.repository.BookRepository;
import com.dantedevfr.books_service.service.BookService;
import com.dantedevfr.books_service.service.validation.BookValidator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookValidator bookValidator;

    public BookServiceImpl(BookRepository bookRepository, BookValidator bookValidator) {
        this.bookRepository = bookRepository;
        this.bookValidator = bookValidator;
    }

    @Override
    public List<Book> getAllValidBooks() {
        return bookRepository.findAll()
                .stream()
                .filter(bookValidator::isValid)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id)
                .filter(bookValidator::isValid);
    }
}
