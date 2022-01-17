package com.example.articlereviewproject.controller;

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

import java.util.List;

@Controller
@RequestMapping("/api/v1")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/articles/{articleId}")
    public ResponseEntity<Article> getArticleById(@PathVariable(value = "articleId") Long articleId) throws ResourceNotFoundException {
        Article article =
                articleService
                        .findById(articleId)
                        .orElseThrow(() -> new ResourceNotFoundException("Article not found on :: " + articleId)); //EAGER a cekmeme ragmen neden gelmiyor?
        return ResponseEntity.ok().body(article);
    }

    @GetMapping("/articles")
    public ResponseEntity<Iterable<Article>> getArticles(@QuerydslPredicate Predicate predicate) {
        return ResponseEntity.ok(articleService.findAll(predicate));
    }

    @PostMapping("/articles")
    public ResponseEntity createArticle(@RequestBody Article article) throws ResourceNotFoundException {
        Article articleDB;
        try{
            articleDB = articleService.saveArticle(article);
        }catch (Exception e){
            throw new CustomException("Create process failed error message : " + e.getMessage());
        }

        return ResponseEntity.ok().body(articleDB);
    }

    @PutMapping("/articles/{articleId}")
    public ResponseEntity updateReview(@PathVariable("articleId") Long articleId, @RequestBody Article article) throws ResourceNotFoundException {

        Article articleDB = articleService
                .findById(articleId)
                .orElseThrow(() -> new ResourceNotFoundException("Review not found on :: " + articleId));

        if(article.getArticleContent() != null){
            articleDB.setArticleContent(article.getArticleContent());
        }
        if(article.getPublishDate() != null){
            articleDB.setPublishDate(article.getPublishDate());
        }
        if(article.getAuthor() != null){
            articleDB.setAuthor(article.getAuthor());
        }
        if(article.getTitle() != null){
            articleDB.setTitle(article.getTitle());
        }
        if(article.getStarCount() != 0){
            articleDB.setStarCount(article.getStarCount());
        }

        try{
            articleService.saveArticle(articleDB);
        }catch (Exception e){
            throw new CustomException("Update process failed error message : " + e.getMessage());
        }

        return ResponseEntity.ok().body(articleDB);
    }

    @DeleteMapping("/articles/{articleId}")
    public ResponseEntity deleteReviewById(@PathVariable(value = "articleId") Long articleId){

        try{
            articleService.deleteById(articleId);
        }catch (Exception e){
            throw new CustomException("Save process failed error message : " + e.getMessage());
        }

        return ResponseEntity.ok().body("Article deleted");
    }
}
