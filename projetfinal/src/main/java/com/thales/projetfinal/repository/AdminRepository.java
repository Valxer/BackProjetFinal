package com.thales.projetfinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thales.projetfinal.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, String> {

	Admin findByIdAndPassword(String id, String pass);

}
