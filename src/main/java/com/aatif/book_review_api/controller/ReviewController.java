package com.aatif.book_review_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aatif.book_review_api.model.Review;
import com.aatif.book_review_api.service.ReviewService;

@RestController
@RequestMapping("/books/{bookId}/reviews")
public class ReviewController {
    
    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping
    public Review addReview(@PathVariable Long bookId, @RequestBody Review review) {
        return reviewService.addReview(bookId, review);
    }

    @GetMapping
    public List<Review> getReviews(@PathVariable Long bookId) {
        return reviewService.getReviewsByBookId(bookId);
    }

    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
    }
}
