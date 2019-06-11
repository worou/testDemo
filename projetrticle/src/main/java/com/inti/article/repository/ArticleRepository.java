package com.inti.article.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inti.article.model.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {

}
