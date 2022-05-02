package com.gustavo.filmes.filmesapi.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "diretor")
public class Diretor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "foto")
    private String foto;


}
