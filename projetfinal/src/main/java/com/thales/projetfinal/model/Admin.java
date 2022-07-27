package com.thales.projetfinal.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Admin {
	@Id
	@JsonView(JsonViews.Common.class)
	private String id;
	@JsonView(JsonViews.Common.class)
	private String password;
	@Version
	private int version;

	public Admin() {
	}

	public Admin(String password, String nom, String prenom) {
		this.password = password;
	}

	public Admin(String password, String nom, String prenom, String adresse) {
		this.password = password;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String mdp) {
		this.password = mdp;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", password=" + password + "]";
	}
}
