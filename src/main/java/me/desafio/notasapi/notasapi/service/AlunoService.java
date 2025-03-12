package me.desafio.notasapi.notasapi.service;

import jakarta.transaction.Transactional;
import me.desafio.notasapi.notasapi.model.Aluno;
import me.desafio.notasapi.notasapi.repository.AlunoRepository;
import me.desafio.notasapi.notasapi.repository.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private NotaRepository notaRepository;

    public List<Aluno> listarTodos() {
        return alunoRepository.findAll();
    }

    public Optional<Aluno> buscarPorId(Long id) {
        return alunoRepository.findById(id);
    }

    public Aluno criarAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public Optional<Aluno> atualizarAluno(Long id, Aluno alunoAtualizado) {
        return alunoRepository.findById(id).map(aluno -> {
            aluno.setNome(alunoAtualizado.getNome());
            aluno.setEmail(alunoAtualizado.getEmail());
            aluno.setMatricula(alunoAtualizado.getMatricula());
            return alunoRepository.save(aluno);
        });
    }

    @Transactional
    public void deletarAluno(Long id) {
        notaRepository.deleteByAlunoId(id);
        alunoRepository.deleteById(id);
    }
}
