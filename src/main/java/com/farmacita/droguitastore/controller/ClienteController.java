package com.farmacita.droguitastore.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.farmacita.droguitastore.repository.ClienteRepository;

public class ClienteController {
	@Autowired
	private ClienteRepository repositoryC;

	
	public ClienteRepository getRepositoryC() {
		return repositoryC;
	}

	public void setRepositoryC(ClienteRepository repositoryC) {
		this.repositoryC = repositoryC;
	}
}
