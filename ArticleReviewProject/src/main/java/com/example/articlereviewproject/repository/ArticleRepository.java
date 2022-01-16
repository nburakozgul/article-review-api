package com.example.articlereviewproject.repository;

import com.example.articlereviewproject.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article,Long> {
}
