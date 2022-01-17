package com.example.articlereviewproject.repository;

import com.example.articlereviewproject.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long>, QuerydslPredicateExecutor<Review> {



}
