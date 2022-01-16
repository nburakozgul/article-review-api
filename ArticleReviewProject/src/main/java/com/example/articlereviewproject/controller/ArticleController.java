package com.example.articlereviewproject.controller;

import com.example.articlereviewproject.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1")
public class ArticleController {
    @Autowired
    private ArticleService articleService;
}
