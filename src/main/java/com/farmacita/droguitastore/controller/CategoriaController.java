package com.farmacita.droguitastore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farmacita.droguitastore.model.Categoria;
import com.farmacita.droguitastore.repository.CategoriaRepository;

@RestController
@RequestMapping("/categoria")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoriaController {
	@Autowired
	private CategoriaRepository repositoryCa;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> getAll(){
		return ResponseEntity.ok(repositoryCa.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> getById(@PathVariable Long id){
		return repositoryCa.findById(id).map(resposta -> ResponseEntity.ok(resposta)).orElse(ResponseEntity.notFound().build());	
	}
	
	@GetMapping("/classe/{classe}")
	public ResponseEntity<List<Categoria>> getByClasse(@PathVariable String classe){
		return ResponseEntity.ok(repositoryCa.findAllByClasseContainingIgnoreCase(classe));
	}
	
	@PostMapping
	public ResponseEntity<Categoria> post(@RequestBody Categoria categoria){
		return ResponseEntity.status(HttpStatus.CREATED).body(repositoryCa.save(categoria));
	}

	public CategoriaRepository getRepositoryCa() {
		return repositoryCa;
	}
	public void setRepositoryCa(CategoriaRepository repositoryCa) {
		this.repositoryCa = repositoryCa;
	}
}
