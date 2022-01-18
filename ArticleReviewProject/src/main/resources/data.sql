INSERT INTO articles (id, article_content, author, publish_date, star_count, title) VALUES (1, 'test', 'burak', CURRENT_TIMESTAMP, 5, 'baslik');

INSERT INTO reviews (id, review_content, reviewer, article_id) VALUES (1, 'test1', 'burak', 1);
INSERT INTO reviews (id, review_content, reviewer, article_id) VALUES (2, 'test2', 'burak', 1);