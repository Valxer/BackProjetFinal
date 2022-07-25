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
import com.thales.projetfinal.model.Article;
import com.thales.projetfinal.model.JsonViews;
import com.thales.projetfinal.repository.ArticleRepository;

@RestController
@RequestMapping("/article")
public class ArticleRestController {

	@Autowired
	private ArticleRepository repo;

	@CrossOrigin(origins = "*")
	@GetMapping("/findall")
	@JsonView(JsonViews.Common.class)
	public List<Article> findall() {
		return repo.findAll();
	}

	@CrossOrigin(origins = "*")
	@GetMapping("/findbyid/{id}")
	@JsonView(JsonViews.Common.class)
	public Article finbyid(@PathVariable(name = "id") int id) {
		return repo.findById(id).get();
	}

	@CrossOrigin(origins = "*")
	@PostMapping("/create")
	public void create(@RequestBody Article p) {
		repo.save(p);
	}

	@CrossOrigin(origins = "*")
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable(name = "id") int id) {
		repo.delete(repo.findById(id).get());
	}

	@CrossOrigin(origins = "*")
	@PutMapping("/update")
	public void update(@RequestBody Article p) {
		repo.save(p);
	}

}
