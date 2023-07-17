package br.com.cadastro.repositories;


import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cadastro.entities.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository <Aluno , UUID>{

	

	

	

	

}
