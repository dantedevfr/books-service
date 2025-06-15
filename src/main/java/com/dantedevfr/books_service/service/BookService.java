package com.dantedevfr.books_service.service;

import com.dantedevfr.books_service.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> getAllValidBooks();
    Optional<Book> getBookById(Long id);

}
