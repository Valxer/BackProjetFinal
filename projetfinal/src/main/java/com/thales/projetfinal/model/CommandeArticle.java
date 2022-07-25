package com.thales.projetfinal.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Version;

@Entity
public class CommandeArticle {
	@EmbeddedId
	private IdCommandeArticle id;
	private int quantite;
	@Version
	private int version;

	public CommandeArticle() {
	}

	public CommandeArticle(IdCommandeArticle id, int quantite) {
		super();
		this.id = id;
		this.quantite = quantite;
	}

	public IdCommandeArticle getId() {
		return id;
	}

	public void setId(IdCommandeArticle id) {
		this.id = id;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "CommandeArticle [id=" + id + ", quantite=" + quantite + ", version=" + version + "]";
	}

}
