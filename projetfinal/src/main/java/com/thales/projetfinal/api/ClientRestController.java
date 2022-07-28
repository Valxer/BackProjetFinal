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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.thales.projetfinal.model.Client;
import com.thales.projetfinal.model.JsonViews;
import com.thales.projetfinal.repository.ClientRepository;

@RestController
@RequestMapping("/client")
public class ClientRestController {

	@Autowired
	private ClientRepository repo;

	@CrossOrigin(origins = "*")
	@GetMapping("/findall")
	@JsonView(JsonViews.Common.class)
	public List<Client> findall() {
		return repo.findAll();
	}

	@CrossOrigin(origins = "*")
	@GetMapping("/findbyid/{id}")
	@JsonView(JsonViews.ClientWithCommandes.class)
	public Client finbyid(@PathVariable(name = "id") String id) {
		return repo.findById(id).get();
	}

	@CrossOrigin(origins = "*")
	@GetMapping("/login/{id}/{pass}")
	@JsonView(JsonViews.Common.class)
	public Client findByMailAndPass(@PathVariable(name = "id") String id, @PathVariable(name = "pass") String pass) {
		Client p = repo.findByIdAndPassword(id, pass);
		return p;
	}

	@CrossOrigin(origins = "*")
	@PostMapping("/create")
	public ResponseEntity<Client> create(@RequestBody Client p) {
		if (repo.findById(p.getId()).isPresent())
			return ResponseEntity.status(400).body(null);
		Client c = repo.save(p);
		return ResponseEntity.created(URI.create(String.format("/client/%s", p.getId()))).body(c);
	}

	@CrossOrigin(origins = "*")
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable(name = "id") String id) {
		repo.delete(repo.findById(id).get());
	}

	@CrossOrigin(origins = "*")
	@PutMapping("/update")
	public void update(@RequestBody Client p) {
		repo.save(p);
	}
}
