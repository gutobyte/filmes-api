package com.gustavo.filmes.filmesapi.service;

import com.gustavo.filmes.filmesapi.model.Diretor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("DiretorService")
public interface DiretorService {

    List<Diretor> listarDiretores();

    Diretor pegarPorId(Long id);

    Diretor cadastrarDiretor(Diretor diretor);

    void deletarDiretor(Long id);

    Diretor alterarDiretor(Diretor diretor);





}
