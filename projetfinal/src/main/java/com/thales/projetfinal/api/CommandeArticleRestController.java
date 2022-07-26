package com.thales.projetfinal.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.thales.projetfinal.model.CommandeArticle;
import com.thales.projetfinal.model.IdCommandeArticle;
import com.thales.projetfinal.model.JsonViews;
import com.thales.projetfinal.repository.CommandeArticleRepository;

@RestController
@RequestMapping("/commandearticle")
public class CommandeArticleRestController {

	@Autowired
	private CommandeArticleRepository repo;

	@CrossOrigin(origins = "*")
	@GetMapping("/findall")
	@JsonView(JsonViews.Common.class)
	public List<CommandeArticle> findall() {
		return repo.findAll();
	}

	@CrossOrigin(origins = "*")
	@GetMapping("/findbyid")
	@JsonView(JsonViews.Common.class)
	public CommandeArticle finbyid(@RequestBody IdCommandeArticle id) {
		return repo.findById(id).get();
	}

	@CrossOrigin(origins = "*")
	@PostMapping("/create")
	public void create(@RequestBody CommandeArticle p) {
		repo.save(p);
	}

	@CrossOrigin(origins = "*")
	@DeleteMapping("/delete")
	public void delete(@RequestBody IdCommandeArticle id) {
		repo.delete(repo.findById(id).get());
	}

	@CrossOrigin(origins = "*")
	@PutMapping("/update")
	public void update(@RequestBody CommandeArticle p) {
		repo.save(p);
	}

}
