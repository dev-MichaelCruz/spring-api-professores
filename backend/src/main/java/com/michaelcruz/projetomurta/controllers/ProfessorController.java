package com.michaelcruz.projetomurta.controllers;


import com.michaelcruz.projetomurta.models.Professor;
import com.michaelcruz.projetomurta.repositories.ProfessorRepository;
import com.michaelcruz.projetomurta.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/professores")
public class ProfessorController {

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private ProfessorService professorService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Professor> listarProfessores(){
        return professorService.listarProfessores();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Professor adicionarProfessor(@RequestBody Professor professor) throws Exception{
         return professorService.adicionarProfessor(professor);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Professor atualizarProfessor(@PathVariable Long id, @RequestBody Professor professor) throws Exception{
        return professorService.atualizarProfessor(id, professor);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletarProfessor(@PathVariable Long id) {
        professorService.deletarProfessor(id);
    }
}
