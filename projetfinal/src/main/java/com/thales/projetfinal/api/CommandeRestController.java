package com.thales.projetfinal.api;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.thales.projetfinal.model.Commande;
import com.thales.projetfinal.model.JsonViews;
import com.thales.projetfinal.repository.CommandeRepository;

@RestController
@RequestMapping("/commande")
public class CommandeRestController {

	@Autowired
	private CommandeRepository repo;

	@CrossOrigin(origins = "*")
	@GetMapping("/findall")
	@JsonView(JsonViews.Common.class)
	public List<Commande> findall() {
		return repo.findAll();
	}

	@CrossOrigin(origins = "*")
	@GetMapping("/findbyid/{id}")
	@JsonView(JsonViews.CommandeWithArticles.class)
	public Commande finbyid(@PathVariable(name = "id") int id) {
		return repo.findById(id).get();
	}

	@CrossOrigin(origins = "*")
	@PostMapping("/create")
	@JsonView(JsonViews.Common.class)
	public ResponseEntity<Commande> create(@RequestBody Commande p) {
		Commande cmd = repo.save(p);
		return ResponseEntity.created(URI.create(String.format("/commande/%s", p.getId()))).body(cmd);
	}

	@CrossOrigin(origins = "*")
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable(name = "id") int id) {
		repo.delete(repo.findById(id).get());
	}

}
