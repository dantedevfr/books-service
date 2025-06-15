package com.dantedevfr.books_service.repository;

import com.dantedevfr.books_service.model.Section;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectionRepository extends JpaRepository<Section, Long> {
}
