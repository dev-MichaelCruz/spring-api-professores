package com.michaelcruz.projetomurta.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "idade")
    private byte idade;

    @Column(name = "curso")
    private String curso;

}
