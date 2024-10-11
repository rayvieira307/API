package br.org.serratec.trabalhoindividual.trabalho.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.trabalhoindividual.trabalho.domain.Livro;
import br.org.serratec.trabalhoindividual.trabalho.repository.LivroRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/livros")
public class LivroController {
     
	@Autowired 
	private LivroRepository livroRepository;
	
	//listar
	@GetMapping
	public ResponseEntity<List<Livro>> listar(){
		return ResponseEntity.ok(livroRepository.findAll());
	}
	
	//buscar por id
	@GetMapping("/{id}")
	public ResponseEntity<Livro> buscar(@PathVariable Long id){
		Optional<Livro> livroOpt = livroRepository.findById(id);
		if (livroOpt.isPresent()) {
			return ResponseEntity.ok(livroOpt.get());
		}
		return ResponseEntity.notFound().build();
	}
	//inserindo dados
		@PostMapping
		@ResponseStatus(HttpStatus.CREATED)
		public Livro inserir(@Valid @RequestBody Livro livro) {
			livro = livroRepository.save(livro);
			return livro;
			
		}
		
		//atualizar dados
		@PutMapping("/{id}")
		public ResponseEntity<Livro> alterar(@PathVariable Long id,
				@Valid @RequestBody Livro livro){
			if (!livroRepository.existsById(id)) {
				return ResponseEntity.notFound().build();
			}
			livro.setId(id);
			livro = livroRepository.save(livro);
			return ResponseEntity.ok(livro);
		}
		
		//deletar dados 
		@DeleteMapping("/{id}")
		public ResponseEntity<Void> deletar (@PathVariable Long id) {
			if (!livroRepository.existsById(id)) {
				return ResponseEntity.notFound().build();
			}
			livroRepository.deleteById(id);
			return ResponseEntity.noContent().build();
		}
	
	
}