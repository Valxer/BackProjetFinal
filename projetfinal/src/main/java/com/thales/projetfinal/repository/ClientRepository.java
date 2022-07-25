package com.thales.projetfinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thales.projetfinal.model.Client;

public interface ClientRepository extends JpaRepository<Client, String> {

	Client findByIdAndPassword(String id, String pass);

}