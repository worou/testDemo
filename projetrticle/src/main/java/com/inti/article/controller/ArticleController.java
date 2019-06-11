package com.inti.article.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inti.article.dao.ArticleDao;
import com.inti.article.model.Article;

@RestController
@CrossOrigin("*")
@RequestMapping("/articleApi")
public class ArticleController {
	
 @Autowired
 ArticleDao articleDao;
 
 //save an Article
 @PostMapping("/articles")
 public Article createArticle(@Valid @RequestBody Article article){
	 return articleDao.addArticle(article);
 }
 
 //get all articles
 @GetMapping("/articles")
 public List<Article> getAllArticles(){
	 return articleDao.getArticles();
 }
 
 //get one article
 @GetMapping("/articles/{id}")
 public ResponseEntity<Article> getArticleById(@PathVariable(value="id") Long idArt){
	 Article article = articleDao.articleItem(idArt);
	 if(article == null) {
		 return ResponseEntity.notFound().build();
	 }
	 return ResponseEntity.ok().body(article);
 }
 
 //update an anrticle
 @PutMapping("/articles")
 public Article updateArticle(@Valid @RequestBody Article article){
	 return articleDao.addArticle(article);
 }
/* @PutMapping("/articles/{id}")
 public ResponseEntity<Article> updateArticle(@PathVariable(value = "id") Long idArt, @Valid @RequestBody Article articleDetail){
	 Article article = articleDao.articleItem(idArt);
	 if(article == null) {
		 return ResponseEntity.notFound().build();
	 }
	 article.setTitre(articleDetail.getTitre());
	 article.setContenu(articleDetail.getContenu());
	 article.setAuteur(articleDetail.getAuteur());
	 article.setUrl(articleDetail.getUrl());
	 article.setParution(articleDetail.getParution());
	 
	 Article articleRecent = articleDao.addArticle(articleDetail);
	 return ResponseEntity.ok().body(articleRecent);
 }*/
 
 //Delete an article
 @DeleteMapping("/articles/{id}")
 public ResponseEntity<Article> deleteArticle(@PathVariable(value = "id") Long idArt){
	 Article article = articleDao.articleItem(idArt);
	 if(article == null) {
		 return ResponseEntity.notFound().build();
	 }
	 articleDao.deleteArticle(article);
	 return ResponseEntity.ok().build();
 }
}
