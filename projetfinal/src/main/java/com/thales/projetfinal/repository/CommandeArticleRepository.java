package com.thales.projetfinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thales.projetfinal.model.CommandeArticle;
import com.thales.projetfinal.model.IdCommandeArticle;

public interface CommandeArticleRepository extends JpaRepository<CommandeArticle, IdCommandeArticle> {

}
