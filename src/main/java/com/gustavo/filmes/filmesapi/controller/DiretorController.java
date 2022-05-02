package com.gustavo.filmes.filmesapi.controller;

import com.gustavo.filmes.filmesapi.model.Diretor;
import com.gustavo.filmes.filmesapi.service.DiretorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/diretores")
public class DiretorController {

    private final DiretorService diretorServiceImpl;

    @GetMapping("/listar")
    List<Diretor> listarDiretores(){
        return diretorServiceImpl.listarDiretores();
    }


    @GetMapping("/{id}")
    Diretor acharDiretorPorId(@PathVariable Long id){
        return diretorServiceImpl.pegarPorId(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/cadastrar")
    Diretor cadastrar(@RequestBody Diretor diretor){
        return diretorServiceImpl.cadastrarDiretor(diretor);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("deletar/{id}")
    void deletarDiretor(@PathVariable Long id){
        diretorServiceImpl.deletarDiretor(id);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("/alterar")
    public Diretor alterar(@RequestBody Diretor diretor){
        return diretorServiceImpl.alterarDiretor(diretor);
    }

}
