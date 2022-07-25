package com.thales.projetfinal.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class IdCommandeArticle implements Serializable {

	@ManyToOne
	@JoinColumn(name = "commande")
	private Commande commande;
	@ManyToOne
	@JoinColumn(name = "article")
	private Article article;

	public IdCommandeArticle(Commande commande, Article article) {
		super();
		this.commande = commande;
		this.article = article;
	}

	public IdCommandeArticle() {
		super();
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	@Override
	public String toString() {
		return "IdCommandeArticle [commande=" + commande + ", article=" + article + "]";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
