package com.inti.article.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.article.model.Article;
import com.inti.article.repository.ArticleRepository;

@Service
public class ArticleDao {

	@Autowired
	ArticleRepository articleRepository;
	
	//save
	public Article addArticle(Article article) {
		return articleRepository.save(article);
	}
	
	//lister
	public List<Article> getArticles(){
		return articleRepository.findAll();
	}

	//get an article
	public Article articleItem(Long idArt) {
		//return articleRepository.getOne(idArt);
		return articleRepository.findById(idArt).get();
	
		
	}
	//delete an article
	public void deleteArticle(Article article) {
		articleRepository.delete(article);
	}
}
