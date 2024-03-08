package com.michaelcruz.projetomurta.repositories;

import com.michaelcruz.projetomurta.models.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {

}
