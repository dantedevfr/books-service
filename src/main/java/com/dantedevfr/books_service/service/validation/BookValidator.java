package com.dantedevfr.books_service.service.validation;
import com.dantedevfr.books_service.model.Book;
import com.dantedevfr.books_service.model.Section;
import com.dantedevfr.books_service.model.SectionType;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class BookValidator {

    public boolean isValid(Book book) {
        return validate(book).isValid();
    }

    public ValidationResult validate(Book book) {
        List<String> errors = new ArrayList<>();

        if (book.getTitle() == null || book.getTitle().isBlank()) {
            errors.add("Title must not be blank.");
        }

        if (book.getAuthor() == null || book.getAuthor().isBlank()) {
            errors.add("Author must not be blank.");
        }

        List<Section> sections = book.getSections();

        if (sections == null || sections.isEmpty()) {
            errors.add("Book must have at least one section.");
        } else {
            long introCount = sections.stream().filter(s -> s.getType() == SectionType.INTRO).count();
            long bodyCount = sections.stream().filter(s -> s.getType() == SectionType.BODY).count();
            long endingCount = sections.stream().filter(s -> s.getType() == SectionType.ENDING).count();

            if (introCount != 1) {
                errors.add("Book must have exactly one INTRO section.");
            }

            if (bodyCount < 1) {
                errors.add("Book must have at least one BODY section.");
            }

            if (endingCount < 1) {
                errors.add("Book must have at least one ENDING section.");
            }
        }

        return new ValidationResult(errors.isEmpty(), errors);
    }
}