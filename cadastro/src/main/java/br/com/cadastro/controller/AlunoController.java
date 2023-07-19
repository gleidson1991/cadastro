package br.com.cadastro.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

import br.com.cadastro.entities.Aluno;
import br.com.cadastro.repositories.AlunoRepository;
import br.com.cadastro.services.AlunoService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/home")
public class AlunoController {

	final AlunoService alunoService;

	public AlunoController(AlunoService alunoService) {
		this.alunoService = alunoService;
	}

	@PostMapping("/salvar")
	public ResponseEntity<Aluno> save(@RequestBody Aluno aluno) {
		return ResponseEntity.status(HttpStatus.CREATED).body(alunoService.save(aluno));
	}
    
        @PutMapping("/editar")
	public ResponseEntity<Aluno> edit(@RequestBody Aluno aluno) {
		return ResponseEntity.status(HttpStatus.CREATED).body(alunoService.save(aluno));
	}
    
	@GetMapping("/alunos")
	public ResponseEntity<List<Aluno>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(alunoService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Aluno> findById(@PathVariable(value = "id") UUID id) {
		Optional<Aluno> aluno = alunoService.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(aluno.get());
	}

	@DeleteMapping("delete/{id}")
	public Aluno deleteById(@PathVariable UUID id) {
		alunoService.deleteById(id);
		return null;
	}

}
