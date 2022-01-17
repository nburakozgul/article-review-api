package com.example.articlereviewproject.service;

import com.example.articlereviewproject.entity.Review;
import com.example.articlereviewproject.repository.ReviewRepository;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    public Optional<Review> findById(Long id){
        return reviewRepository.findById(id);
    };

    public List<Review> findAll(){
        return reviewRepository.findAll();
    }

    public Iterable<Review> findAll(Predicate predicate){return reviewRepository.findAll(predicate);}

    public Review saveReview(Review review){
        return reviewRepository.save(review);
    }

    public void deleteById(Long id){
        reviewRepository.deleteById(id);
    }
}
