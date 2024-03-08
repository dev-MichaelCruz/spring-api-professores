package com.michaelcruz.projetomurta.repositories;

import com.michaelcruz.projetomurta.models.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
