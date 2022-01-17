package com.example.articlereviewproject.repository;

import com.example.articlereviewproject.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ArticleRepository extends JpaRepository<Article,Long>, QuerydslPredicateExecutor<Article> {

}
