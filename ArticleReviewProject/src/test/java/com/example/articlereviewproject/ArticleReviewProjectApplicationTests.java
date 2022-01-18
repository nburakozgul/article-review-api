package com.example.articlereviewproject;

import com.example.articlereviewproject.entity.Review;
import com.example.articlereviewproject.service.ReviewService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Optional;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class ArticleReviewProjectApplicationTests {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ReviewService reviewService;

    @Autowired
    ObjectMapper objectMapper;



    @Test
    public void whenGetArticlesCompareWithDB()
            throws Exception {

        Optional<Review> review = reviewService.findById(Long.parseLong("1")); // neden?
        String reviewAsString = objectMapper.writeValueAsString(review);

        mvc.perform(get("/api/v1/reviews/1")
                 .with(user("sa").password("password"))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().json(reviewAsString, false));
    }

}
