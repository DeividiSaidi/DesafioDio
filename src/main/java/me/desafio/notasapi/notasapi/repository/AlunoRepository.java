package me.desafio.notasapi.notasapi.repository;

import me.desafio.notasapi.notasapi.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno,Long> {
    Optional<Aluno> findByMatricula(String matricula);
}
