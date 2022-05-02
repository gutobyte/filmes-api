package com.gustavo.filmes.filmesapi.controller;


import com.gustavo.filmes.filmesapi.model.Filme;
import com.gustavo.filmes.filmesapi.repository.FilmeRepository;
import com.gustavo.filmes.filmesapi.service.FilmeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/filmes")
public class FilmeController {

    private final FilmeRepository filmeRepository;
    private final FilmeService filmeServiceImpl;

    @GetMapping("listar")
    public List<Filme> listarTodosFilmes(){
        return filmeServiceImpl.listarTodosFilmes();
    }


    //posteriormente fazer validação de filme já cadastrado
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("cadastrar")
    public Filme cadastrarFilme(@RequestBody Filme filme){
        return filmeServiceImpl.cadastrarFilme(filme);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("deletar/{id}")
    public void deletarFilme(@PathVariable Long id){
        filmeServiceImpl.deletarFilme(id);
    }

    @PutMapping("alterar")
    public Filme alterarFilme(@RequestBody Filme filme){
       return filmeServiceImpl.alterarFilme(filme);
    }

}
