package com.farmacita.droguitastore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farmacita.droguitastore.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
