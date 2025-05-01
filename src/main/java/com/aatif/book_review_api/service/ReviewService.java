package com.aatif.book_review_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aatif.book_review_api.model.Book;
import com.aatif.book_review_api.model.Review;
import com.aatif.book_review_api.repository.BookRepository;
import com.aatif.book_review_api.repository.ReviewRepository;

@Service
public class ReviewService {
    
    private final ReviewRepository reviewRepository;
    private final BookRepository bookRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository, BookRepository bookRepository) {
        this.reviewRepository = reviewRepository;
        this.bookRepository = bookRepository;
    }

    public Review addReview(Long bookId, Review review) {
        Book book = bookRepository.findById(bookId)
            .orElseThrow(() -> new RuntimeException("Book not found"));

        review.setBook(book);
        return reviewRepository.save(review);
    }

    public List<Review> getReviewsByBookId(Long bookId) {
        return reviewRepository.findByBookId(bookId);
    }

    public void deleteReview(Long id) {
        if (!reviewRepository.existsById(id)) {
            throw new RuntimeException("Review not found with id: " + id);
        }
        reviewRepository.deleteById(id);
    }    
}
