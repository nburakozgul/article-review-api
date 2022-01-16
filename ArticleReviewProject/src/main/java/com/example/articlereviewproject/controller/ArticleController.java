package com.example.articlereviewproject.controller;

import com.example.articlereviewproject.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ArticleController {
    @Autowired
    private ArticleService articleService;
}
