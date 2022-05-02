package com.gustavo.filmes.filmesapi.model;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "filme")
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "titulo_brasil")
    private String tituloBrasil;

    @Column(name = "titulo_original", nullable = false)
    private String tituloOriginal;

    @Column(name = "ano_lancamento", nullable = false)
    private String ano;

    @Column(name = "nacionalidade", nullable = false)
    private String nacionalidade;

/*
    @ManyToOne
    @JoinColumn(name = "id_diretor")
    private Diretor diretor;
*/

    @Column(name = "sipnose", nullable = false, length = 1000)
    private String sipnose;

    @Column(name = "foto")
    private String foto;



}
