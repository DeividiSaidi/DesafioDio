package me.desafio.notasapi.notasapi.service;

import me.desafio.notasapi.notasapi.dto.NotaDTO;
import me.desafio.notasapi.notasapi.model.Aluno;
import me.desafio.notasapi.notasapi.model.Nota;
import me.desafio.notasapi.notasapi.repository.AlunoRepository;
import me.desafio.notasapi.notasapi.repository.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotaService {
    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    public NotaRepository notaRepository;

    public List<Nota> listarTodas() {
        return notaRepository.findAll();
    }

    public Optional<Nota> buscarPorId(Long id) {
        return notaRepository.findById(id);
    }

    public List<Nota> buscarPorAluno(Long idAluno) {
        return notaRepository.findByAlunoId(idAluno);
    }

    public Nota criarNota(NotaDTO notaDTO) {
        Aluno aluno = alunoRepository.findById(notaDTO.getIdAluno())
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
        Nota nota = new Nota();
        nota.setAluno(aluno);
        nota.setDisciplina(notaDTO.getDisciplina());
        nota.setNota(notaDTO.getNota());
        return notaRepository.save(nota);
    }

    public Optional<Nota> atualizarNota(Long id, Nota notaAtualizada) {
        return notaRepository.findById(id).map(nota -> {
            nota.setDisciplina(notaAtualizada.getDisciplina());
            nota.setNota(notaAtualizada.getNota());
            return notaRepository.save(nota);
        });
    }

    public void deletarNota(Long id) {
        notaRepository.deleteById(id);
    }
}
