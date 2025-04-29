package com.aatif.book_review_api.repository;

import com.aatif.book_review_api.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    // Add custom query methods here later if needed
}
