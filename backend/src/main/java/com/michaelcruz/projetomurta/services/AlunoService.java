package com.michaelcruz.projetomurta.services;

import com.michaelcruz.projetomurta.models.Aluno;
import com.michaelcruz.projetomurta.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    AlunoRepository alunoRepository;

    public List<Aluno> listarAlunos(){
        return alunoRepository.findAll();
    }

    public Aluno adicionarAluno(@RequestBody Aluno aluno){
        return alunoRepository.save(aluno);
    }

    public void atualizarAluno(Long id, Aluno aluno){
        Optional<Aluno> optionalAluno = alunoRepository.findById(id);

        if(optionalAluno.isPresent()){
            Aluno alunoExistente = optionalAluno.get();

            alunoExistente.setNome(aluno.getNome());
            alunoExistente.setIdade(aluno.getIdade());
            alunoExistente.setCurso(aluno.getCurso());

            alunoRepository.save(alunoExistente);

            ResponseEntity.noContent().build();
        } else {
            ResponseEntity.notFound().build();
        }
    }

    public void deletarAluno(Long id) {
        Optional<Aluno> optionalAluno = alunoRepository.findById(id);

        if(optionalAluno.isPresent()){
            alunoRepository.deleteById(id);
            ResponseEntity.noContent().build();
        } else {
            ResponseEntity.notFound().build();
        }
    }
}
