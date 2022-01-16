package com.example.articlereviewproject.controller;

import com.example.articlereviewproject.entity.Article;
import com.example.articlereviewproject.entity.Review;
import com.example.articlereviewproject.error.CustomException;
import com.example.articlereviewproject.error.ResourceNotFoundException;
import com.example.articlereviewproject.service.ArticleService;
import com.example.articlereviewproject.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/v1")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @Autowired
    private ArticleService articleService;

    @GetMapping("/reviews")
    public List<Review> getAllReviews() {
        return reviewService.findAll();
    }

    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> getReviewById(@PathVariable(value = "reviewId") Long reviewId) throws ResourceNotFoundException {
        Review review =
                    reviewService
                        .findById(reviewId)
                            .orElseThrow(() -> new ResourceNotFoundException("Review not found on :: " + reviewId));
        return ResponseEntity.ok().body(review);
    }

    @PostMapping("/reviews")
    public ResponseEntity createReview(@RequestBody Review review) throws ResourceNotFoundException {

        Article article = articleService
                .findById(review.getA_id())
                .orElseThrow(() -> new ResourceNotFoundException("Article not found on :: " + review.getA_id()));
        review.setArticle(article);

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
