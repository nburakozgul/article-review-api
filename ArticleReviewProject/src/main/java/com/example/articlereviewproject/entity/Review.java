package com.example.articlereviewproject.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String reviewer;
    private String reviewContent;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="article_id", nullable=false)
    @JsonBackReference
    private Article article;

    public Review(Long id, String reviewer, String reviewContent, Article article) {
        this.id = id;
        this.reviewer = reviewer;
        this.reviewContent = reviewContent;
        this.article = article;
    }

    public Review(String reviewer, String reviewContent, Article article) {
        this.reviewer = reviewer;
        this.reviewContent = reviewContent;
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

}
