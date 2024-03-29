package com.example.articlereviewproject.service;

import com.example.articlereviewproject.entity.Article;
import com.example.articlereviewproject.repository.ArticleRepository;
import com.querydsl.core.types.Predicate;
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

    public Iterable<Article> findAll(Predicate predicate){return articleRepository.findAll(predicate);}

    public Article saveArticle(Article article){
        return articleRepository.save(article);
    }

    public void deleteById(Long id){
        articleRepository.deleteById(id);
    }
}
