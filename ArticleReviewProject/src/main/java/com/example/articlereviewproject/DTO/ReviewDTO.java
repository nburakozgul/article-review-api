package com.example.articlereviewproject.DTO;

import com.example.articlereviewproject.entity.Article;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

public class ReviewDTO {

    private String reviewer;
    private String reviewContent;
    private Long articleId;


    public ReviewDTO(String reviewer, String reviewContent, Long articleId) {
        this.reviewer = reviewer;
        this.reviewContent = reviewContent;
        this.articleId = articleId;
    }

    public ReviewDTO() {

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

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }
}
