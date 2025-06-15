package com.dantedevfr.books_service.service.impl;
import com.dantedevfr.books_service.dto.BookDto;
import com.dantedevfr.books_service.exception.BookNotFoundException;
import com.dantedevfr.books_service.exception.InvalidBookException;
import com.dantedevfr.books_service.mapper.BookMapper;
import com.dantedevfr.books_service.model.Book;
import com.dantedevfr.books_service.repository.BookRepository;
import com.dantedevfr.books_service.service.BookService;
import com.dantedevfr.books_service.service.validation.BookValidator;
import com.dantedevfr.books_service.service.validation.ValidationResult;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookValidator bookValidator;
    private final BookMapper bookMapper;

    public BookServiceImpl(BookRepository bookRepository, BookValidator bookValidator, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookValidator = bookValidator;
        this.bookMapper = bookMapper;
    }

    @Override
    public List<BookDto> getAllValidBooks() {
        List<Book> allBooks = bookRepository.findAll();

        if (allBooks.isEmpty()) {
            throw new InvalidBookException("No books found in database", List.of("The books table is empty"));
        }

        List<BookDto> validBooks = allBooks.stream()
                .filter(bookValidator::isValid)
                .map(bookMapper::toDto)
                .collect(Collectors.toList());

        if (validBooks.isEmpty()) {
            throw new InvalidBookException("No valid books found", List.of("All books failed validation rules"));
        }

        return validBooks;
    }

    @Override
    public BookDto getBookById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book with ID " + id + " not found"));

        ValidationResult result = bookValidator.validate(book);

        if (!result.isValid()) {
            throw new InvalidBookException("Book with ID " + id + " is invalid", result.getErrors());
        }

        return bookMapper.toDto(book);
    }
}
