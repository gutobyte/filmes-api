package com.gustavo.filmes.filmesapi.service;

import com.gustavo.filmes.filmesapi.model.Filme;


import java.util.List;

public interface FilmeService {

    List<Filme> listarTodosFilmes();

    Filme cadastrarFilme(Filme filme);

    void deletarFilme(Long id);

    Filme alterarFilme(Filme filme);

}
