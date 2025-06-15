package com.dantedevfr.books_service.mapper;
import com.dantedevfr.books_service.dto.BookDto;
import com.dantedevfr.books_service.dto.SectionDto;
import com.dantedevfr.books_service.model.Book;
import com.dantedevfr.books_service.model.Section;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookMapper {
    public BookDto toDto(Book book) {
        List<SectionDto> sectionDtos = book.getSections().stream()
                .map(this::toDto)
                .collect(Collectors.toList());

        return new BookDto(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getDescription(),
                sectionDtos
        );
    }

    public SectionDto toDto(Section section) {
        return new SectionDto(
                section.getId(),
                section.getContent(),
                section.getType()
        );
    }
}
