package com.michaelcruz.projetomurta.controllers;

import com.michaelcruz.projetomurta.models.Aluno;
import com.michaelcruz.projetomurta.repositories.AlunoRepository;
import com.michaelcruz.projetomurta.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/alunos")
public class AlunoController {

    @Autowired
    AlunoRepository alunoRepository;

    @Autowired
    AlunoService alunoService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Aluno> listarAlunos(){
        return alunoService.listarAlunos();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Aluno adicionarAluno(@RequestBody Aluno aluno){
        return alunoService.adicionarAluno(aluno);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void atualizarAluno(@PathVariable Long id, @RequestBody Aluno aluno){
        alunoService.atualizarAluno(id, aluno);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletarAluno(@PathVariable Long id){
        alunoService.deletarAluno(id);
    }
}
