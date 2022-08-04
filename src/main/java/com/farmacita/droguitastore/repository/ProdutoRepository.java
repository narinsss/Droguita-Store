package com.farmacita.droguitastore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farmacita.droguitastore.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
