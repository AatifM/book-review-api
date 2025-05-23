package com.aatif.book_review_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aatif.book_review_api.model.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long>{
    List<Review> findByBookId(Long bookId);
}
