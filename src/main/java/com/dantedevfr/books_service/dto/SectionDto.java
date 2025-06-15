package com.dantedevfr.books_service.dto;
import com.dantedevfr.books_service.model.SectionType;

public class SectionDto {
    private Long id;
    private String content;
    private SectionType type;

    public SectionDto() {
    }

    public SectionDto(Long id, String content, SectionType type) {
        this.id = id;
        this.content = content;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public SectionType getType() {
        return type;
    }

    public void setType(SectionType type) {
        this.type = type;
    }
}
