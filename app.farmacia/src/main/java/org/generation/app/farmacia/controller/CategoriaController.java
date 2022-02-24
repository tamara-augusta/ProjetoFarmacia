package org.generation.app.farmacia.controller;

import java.util.List;

import org.generation.app.farmacia.model.Categoria;
import org.generation.app.farmacia.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/categoria")
@CrossOrigin ("*")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> findAllCategoria(){
		return ResponseEntity.ok(repository.findAll());
		
	}
	@GetMapping ("/{id}")
	public ResponseEntity<Categoria> findByIdCategoria (@PathVariable Long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok (resp))
				.orElse(ResponseEntity.notFound().build());
						
	}

}