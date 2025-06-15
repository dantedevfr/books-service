package com.dantedevfr.books_service.dto;
import java.util.List;

public class BookDto {
    private Long id;
    private String title;
    private String author;
    private String description;
    private List<SectionDto> sections;

    public BookDto() {
    }

    public BookDto(Long id, String title, String author, String description, List<SectionDto> sections) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.description = description;
        this.sections = sections;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<SectionDto> getSections() {
        return sections;
    }

    public void setSections(List<SectionDto> sections) {
        this.sections = sections;
    }

}
