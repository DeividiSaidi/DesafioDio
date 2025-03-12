package me.desafio.notasapi.notasapi.controller;

import me.desafio.notasapi.notasapi.dto.NotaDTO;
import me.desafio.notasapi.notasapi.model.Nota;
import me.desafio.notasapi.notasapi.service.NotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/notas")
public class NotaController {
    @Autowired
    public NotaService notaService;

    @GetMapping
    public List<Nota> listarTodas() {
        return notaService.listarTodas();
    }

    @GetMapping("/filter/{id}")
    public ResponseEntity<Nota> buscarPorId(@PathVariable Long id) {
        Optional<Nota> notaOptional = notaService.buscarPorId(id);
        return notaOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/aluno/{idAluno}")
    public List<Nota> buscarPorAluno(@PathVariable Long idAluno) {
        return notaService.buscarPorAluno(idAluno);
    }

    @PostMapping("/create/{idAluno}")
    public ResponseEntity<Nota> criarNota(@PathVariable("idAluno") Long idAluno, @RequestBody NotaDTO notaDTO) {
        notaDTO.setIdAluno(idAluno);
        Nota novaNota = notaService.criarNota(notaDTO);
        return ResponseEntity.ok(novaNota);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Nota> atualizarNota(@PathVariable Long id, @RequestBody Nota nota) {
        Optional<Nota> notaOptional = notaService.atualizarNota(id, nota);
        return notaOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Nota> deletarNota(@PathVariable Long id) {
        notaService.deletarNota(id);
        return ResponseEntity.noContent().build();
    }

}
