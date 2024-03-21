package com.michaelcruz.projetomurta.services;

import com.michaelcruz.projetomurta.models.Professor;
import com.michaelcruz.projetomurta.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    @Autowired
    ProfessorRepository professorRepository;

    public List<Professor> listarProfessores(){
        return professorRepository.findAll();
    }

    public ResponseEntity<Professor> adicionarProfessor(@RequestBody Professor professor) throws Exception {
        if(professor.getNome().isEmpty() ||
                professor.getMateria().isEmpty() || professor.getTelefone().isEmpty() ||
                professor.getEmail().isEmpty() || professor.getEndereco().isEmpty()){

            ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            throw new Exception("Erro ao cadastrar professor");

        } else {
           professorRepository.save(professor);
           return ResponseEntity.status(HttpStatus.OK).build();
        }
    }
    public ResponseEntity<Professor> atualizarProfessor(Long id, Professor professor){

        Optional<Professor> optionalProfessor = professorRepository.findById(id);

        try {
            if(optionalProfessor.isPresent()) {

                Professor professorExistente = optionalProfessor.get();

                professorExistente.setNome(professor.getNome());
                professorExistente.setMateria(professor.getMateria());
                professorExistente.setEndereco(professor.getEndereco());
                professorExistente.setTelefone(professor.getTelefone());
                professorExistente.setEmail(professor.getEmail());

                professorRepository.save(professorExistente);

                return ResponseEntity.status(HttpStatus.OK).build();
            }

            return null;

        } catch (Exception ex){
            System.out.println("Erro ao atualizar professor");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    public void deletarProfessor(Long id){
        Optional<Professor> optionalProfessor = professorRepository.findById(id);

        if(optionalProfessor.isPresent()){
            professorRepository.deleteById(id);
            ResponseEntity.noContent().build();
        } else {
            ResponseEntity.notFound().build();
        }
    }

}
