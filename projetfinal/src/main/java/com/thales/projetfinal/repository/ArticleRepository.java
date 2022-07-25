package com.thales.projetfinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thales.projetfinal.model.Article;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

}
