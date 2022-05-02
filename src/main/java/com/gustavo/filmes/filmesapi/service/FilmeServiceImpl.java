package com.gustavo.filmes.filmesapi.service;

import com.gustavo.filmes.filmesapi.exception.MensagemException;
import com.gustavo.filmes.filmesapi.model.Filme;
import com.gustavo.filmes.filmesapi.repository.FilmeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequiredArgsConstructor
@Service("FilmeService")
public class FilmeServiceImpl implements FilmeService{

    private final FilmeRepository filmeRepository;


    public List<Filme> listarTodosFilmes(){
        return filmeRepository.findAll();
    }


    public Filme cadastrarFilme(Filme filme){
        return filmeRepository.save(filme);
    }

    public void deletarFilme(Long id){
        Filme filme = filmeRepository.findById(id)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, MensagemException.FILME_NAO_ENCONTRADO.toString())
                );
        filmeRepository.delete(filme);
    }


    public Filme alterarFilme(Filme filme){
        Filme filmeEncontrado = filmeRepository.findById(filme.getId())
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, MensagemException.FILME_NAO_ENCONTRADO.toString())
                );

        filme.setId(filmeEncontrado.getId());
        return filmeRepository.save(filme);
    }
}
