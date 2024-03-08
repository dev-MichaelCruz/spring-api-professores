package com.michaelcruz.projetomurta.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="nome", nullable = false)
    private String nome;

    @Column(name = "materia", nullable = false)
    private String materia;

    @Column(name = "endereco", nullable = false)
    private String endereco;

    @Column(name = "telefone", nullable = false)
    private String telefone;

    @Column(name = "email", nullable = false)
    private String email;

}
