package com.thales.projetfinal.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.thales.projetfinal.model.Admin;
import com.thales.projetfinal.model.JsonViews;
import com.thales.projetfinal.repository.AdminRepository;

@RestController
@RequestMapping("/admin")
public class AdminRestController {

	@Autowired
	private AdminRepository repo;

	@CrossOrigin(origins = "*")
	@GetMapping("/findall")
	@JsonView(JsonViews.Common.class)
	public List<Admin> findall() {
		return repo.findAll();
	}

	@CrossOrigin(origins = "*")
	@GetMapping("/findbyid/{id}")
	@JsonView(JsonViews.ClientWithCommandes.class)
	public Admin finbyid(@PathVariable(name = "id") String id) {
		return repo.findById(id).get();
	}

	@CrossOrigin(origins = "*")
	@GetMapping("/login/{id}/{pass}")
	@JsonView(JsonViews.Common.class)
	public Admin findByMailAndPass(@PathVariable(name = "id") String id, @PathVariable(name = "pass") String pass) {
		Admin p = repo.findByIdAndPassword(id, pass);
		return p;
	}

	@CrossOrigin(origins = "*")
	@PostMapping("/create")
	public void create(@RequestBody Admin p) {
		repo.save(p);
	}

	@CrossOrigin(origins = "*")
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable(name = "id") String id) {
		repo.delete(repo.findById(id).get());
	}

	@CrossOrigin(origins = "*")
	@PutMapping("/update")
	public void update(@RequestBody Admin p) {
		repo.save(p);
	}
}
