package com.gabriel.bookstore.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabriel.bookstore.domain.Categoria;
import com.gabriel.bookstore.domain.Livro;
import com.gabriel.bookstore.repositories.LivroRepository;
import com.gabriel.bookstore.services.exceptions.ObjectNotFoundException;

@Service
public class LivroService {

	@Autowired
	private LivroRepository repository;

	public Livro findById(Integer id) {
		Optional<Livro> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado, ID:" + id + ", Tipo: " + Livro.class.getName()));
	}
}
