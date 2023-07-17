package br.com.cadastro.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cadastro.entities.Aluno;
import br.com.cadastro.repositories.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository alunoRepository;

	@Transactional
	public Aluno save(Aluno aluno) {
		alunoRepository.save(aluno);
		return aluno;
	}

	public List<Aluno> findAll() {
		List<Aluno> alunos = alunoRepository.findAll();
		return alunos;
	}

	public Optional<Aluno> findById(UUID id) {
		return alunoRepository.findById(id);
	}

	public void deleteById(UUID id) {
		alunoRepository.deleteById(id);

	}
}
