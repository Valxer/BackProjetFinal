package com.thales.projetfinal.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class ConsoleService implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Back servi avec succès !");
	}

}
