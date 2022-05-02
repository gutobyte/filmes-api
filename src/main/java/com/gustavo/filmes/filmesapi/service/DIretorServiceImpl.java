package com.gustavo.filmes.filmesapi.service;

import com.gustavo.filmes.filmesapi.exception.MensagemException;
import com.gustavo.filmes.filmesapi.model.Diretor;
import com.gustavo.filmes.filmesapi.repository.DiretorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class DIretorServiceImpl implements DiretorService{


    private final DiretorRepository diretorRepository;

    @Override
    public List<Diretor> listarDiretores() {
        return diretorRepository.findAll();
    }

    @Override
    public Diretor pegarPorId(Long id) {

        return diretorRepository.findById(id)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, MensagemException.DIRETOR_NAO_ENCONTRADO.toString()));
    }

    @Override
    public Diretor cadastrarDiretor(Diretor diretor)  {
       if(verificarExisteDiretorCadastrado(diretor.getNome())){
           throw new ResponseStatusException(HttpStatus.BAD_REQUEST, MensagemException.DIRETOR_JA_EXISTE.toString());
       }
        return diretorRepository.save(diretor);
    }

    @Override
    public void deletarDiretor(Long id) {
        Diretor deletar = diretorRepository
                .findById(id)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, MensagemException.DIRETOR_NAO_ENCONTRADO.toString()));
        diretorRepository.delete(deletar);

    }

    @Override
    public Diretor alterarDiretor(Diretor diretor) {
        Diretor alterar = diretorRepository
                .findById(diretor.getId())
                .orElseThrow(
                        ()-> new ResponseStatusException(HttpStatus.NOT_FOUND,
                                MensagemException.DIRETOR_NAO_ENCONTRADO.toString()));
        diretor.setId(alterar.getId());
        return diretorRepository.save(diretor);
    }

    private boolean verificarExisteDiretorCadastrado(String nomeDiretor){
        Optional <Diretor> diretorENcontrado = Optional.ofNullable(diretorRepository.findByNome(nomeDiretor));
        return diretorENcontrado.isPresent();
    }
}
