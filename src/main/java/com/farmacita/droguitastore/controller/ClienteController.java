package com.farmacita.droguitastore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.farmacita.droguitastore.model.Categoria;
import com.farmacita.droguitastore.model.Cliente;
import com.farmacita.droguitastore.repository.ClienteRepository;

@RestController
@RequestMapping("/cliente")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ClienteController {
	@Autowired
	private ClienteRepository repositoryC;
	
	@GetMapping
	public ResponseEntity<List<Cliente>> getAll(){
		return ResponseEntity.ok(repositoryC.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> getById(@PathVariable Long id){
		return repositoryC.findById(id).map(resp -> ResponseEntity.ok(resp)
				).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Cliente>> getByNome(@PathVariable String nome){
		return ResponseEntity.ok(repositoryC.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@PostMapping
	public ResponseEntity<Cliente> post(@RequestBody Cliente cliente){
		return ResponseEntity.status(HttpStatus.CREATED).body(repositoryC.save(cliente));
	}
	
	@PutMapping
	public ResponseEntity<Cliente> put(@RequestBody Cliente cliente){
		return ResponseEntity.status(HttpStatus.OK).body(repositoryC.save(cliente));
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		repositoryC.deleteById(id);
	}
	
	public ClienteRepository getRepositoryC() {
		return repositoryC;
	}

	public void setRepositoryC(ClienteRepository repositoryC) {
		this.repositoryC = repositoryC;
	}
}
