package com.example.articlereviewproject.repository;

import com.example.articlereviewproject.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long>, QuerydslPredicateExecutor<Review> {



}
