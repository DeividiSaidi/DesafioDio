package me.desafio.notasapi.notasapi.repository;

import me.desafio.notasapi.notasapi.model.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotaRepository extends JpaRepository<Nota, Long> {
    List<Nota> findByAlunoId(Long alunoId);

    @Modifying
    @Query("DELETE FROM Nota n WHERE n.aluno.id = :alunoId")
    void deleteByAlunoId(@Param("alunoId") Long alunoId);
}
