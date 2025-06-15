package com.dantedevfr.books_service.service;
import com.dantedevfr.books_service.dto.BookDto;
import java.util.List;

public interface BookService {
    List<BookDto> getAllValidBooks();
    BookDto getBookById(Long id);
}
