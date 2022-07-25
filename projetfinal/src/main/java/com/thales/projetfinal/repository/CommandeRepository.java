package com.thales.projetfinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thales.projetfinal.model.Commande;

public interface CommandeRepository extends JpaRepository<Commande, Integer> {

}
