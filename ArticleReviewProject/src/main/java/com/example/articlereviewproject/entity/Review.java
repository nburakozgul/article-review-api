package com.example.articlereviewproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String reviewer;
    private String reviewContent;
    private Long a_id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Article article;

    public Review(Long id, String reviewer, String reviewContent,Long a_id, Article article) {
        this.id = id;
        this.reviewer = reviewer;
        this.reviewContent = reviewContent;
        this.a_id = a_id;
        this.article = article;
    }

    public Review() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Long getA_id() {
        return a_id;
    }

    public void setA_id(Long a_id) {
        this.a_id = a_id;
    }
}
