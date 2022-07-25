package com.thales.projetfinal.model;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(JsonViews.Common.class)
	private int ref;
	@JsonView(JsonViews.Common.class)
	private String nom;
	@JsonView(JsonViews.Common.class)
	private String description;
	@JsonView(JsonViews.Common.class)
	private int prix;
	@JsonView(JsonViews.Common.class)
	private String image;
	@ElementCollection(targetClass = IdCommandeArticle.class)
	@JsonView(JsonViews.ArticleWithCommandes.class)
	private List<IdCommandeArticle> commandes;
	@Version
	private int version;

	public Article(String nom, String description, int prix, String image) {
		this.nom = nom;
		this.description = description;
		this.prix = prix;
		this.image = image;
	}

	public Article() {
	}

	public List<IdCommandeArticle> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<IdCommandeArticle> commandes) {
		this.commandes = commandes;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public int getRef() {
		return ref;
	}

	public void setRef(int ref) {
		this.ref = ref;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Article [ref=" + ref + ", nom=" + nom + ", description=" + description + ", prix=" + prix + ", image="
				+ image + "]";
	}

}
