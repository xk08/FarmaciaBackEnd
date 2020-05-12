package com.meudominio.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meudominio.api.entities.Drug;

@Repository //Define que é um componente do Spring
public interface DrugRepository extends JpaRepository<Drug, Long> {
	
	List<Drug> findByTitle(String title);
	
}
