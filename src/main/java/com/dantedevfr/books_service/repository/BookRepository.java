package com.dantedevfr.books_service.repository;

import com.dantedevfr.books_service.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  BookRepository extends JpaRepository<Book, Long> {
}
