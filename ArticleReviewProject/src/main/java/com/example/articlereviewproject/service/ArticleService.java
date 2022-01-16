package com.example.articlereviewproject.service;

import com.example.articlereviewproject.entity.Article;
import com.example.articlereviewproject.entity.Review;
import com.example.articlereviewproject.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    public Optional<Article> findById(Long id){
        return articleRepository.findById(id);
    };

    public List<Article> findAll(){
        return articleRepository.findAll();
    }

    public Article saveReview(Article article){
        return articleRepository.save(article);
    }

    public void deleteById(Long id){
        articleRepository.deleteById(id);
    }
}
