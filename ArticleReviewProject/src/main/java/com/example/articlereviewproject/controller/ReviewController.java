package com.example.articlereviewproject.controller;

import com.example.articlereviewproject.DTO.ReviewDTO;
import com.example.articlereviewproject.entity.Article;
import com.example.articlereviewproject.entity.Review;
import com.example.articlereviewproject.error.CustomException;
import com.example.articlereviewproject.error.ResourceNotFoundException;
import com.example.articlereviewproject.service.ArticleService;
import com.example.articlereviewproject.service.ReviewService;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/v1")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @Autowired
    private ArticleService articleService;

    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> getReviewById(@PathVariable(value = "reviewId") Long reviewId) throws ResourceNotFoundException {
        Review review =
                    reviewService
                        .findById(reviewId)
                            .orElseThrow(() -> new ResourceNotFoundException("Review not found on :: " + reviewId));
        return ResponseEntity.ok().body(review);
    }

    @GetMapping("/reviews")
    public ResponseEntity<Iterable<Review>> getReview(@QuerydslPredicate Predicate predicate) {
        return ResponseEntity.ok(reviewService.findAll(predicate));
    }

    @PostMapping("/reviews")
    public ResponseEntity createReview(@RequestBody ReviewDTO reviewDTO) throws ResourceNotFoundException {

        Article article = articleService
                .findById(reviewDTO.getArticleId())
                .orElseThrow(() -> new ResourceNotFoundException("Article not found on :: " + reviewDTO.getArticleId()));

        Review review = new Review(reviewDTO.getReviewer(),reviewDTO.getReviewContent(), article); // mapper kullanabilirsin

        try{
            reviewService.saveReview(review);
        }catch (Exception e){
            throw new CustomException("Create process failed error message : " + e.getMessage());
        }

        return ResponseEntity.ok().body(review);
    }

    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity updateReview(@PathVariable("reviewId") Long reviewId, @RequestBody Review review) throws ResourceNotFoundException {

        Review reviewDB = reviewService
                .findById(reviewId)
                .orElseThrow(() -> new ResourceNotFoundException("Review not found on :: " + reviewId));

        if(review.getReviewer() != null){
            reviewDB.setReviewer(review.getReviewer());
        }
        if(review.getReviewContent() != null){
            reviewDB.setReviewContent(review.getReviewContent());
        }

        try{
            reviewService.saveReview(reviewDB);
        }catch (Exception e){
            throw new CustomException("Update process failed error message : " + e.getMessage());
        }

        return ResponseEntity.ok().body(reviewDB);
    }

    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity deleteReviewById(@PathVariable(value = "reviewId") Long reviewId){
        Review review = null;

        try{
             review = reviewService
                    .findById(reviewId)
                    .orElseThrow(() -> new ResourceNotFoundException("Review not found on :: " + reviewId));

            reviewService.deleteById(reviewId);
        }catch (Exception e){
            throw new CustomException("Save process failed error message : " + e.getMessage());
        }

        return ResponseEntity.ok().body(review);
    }
}
