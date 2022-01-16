package com.example.articlereviewproject.controller;

import com.example.articlereviewproject.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ReviewController {
    @Autowired
    private ReviewService reviewService;
}
