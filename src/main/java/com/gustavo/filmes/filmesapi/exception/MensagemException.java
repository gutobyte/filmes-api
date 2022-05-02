package com.gustavo.filmes.filmesapi.exception;

public enum MensagemException {

    DIRETOR_NAO_ENCONTRADO("Diretor não encontrado"),
    DIRETOR_JA_EXISTE("Diretor já existe"),
    FILME_NAO_ENCONTRADO("Filme não encontrado"),
    FILME_JA_EXISTE("Filme já cadastrado");


    private final String mesagem;

    MensagemException(String mesagem) {
        this.mesagem = mesagem;
    }

    @Override
    public String toString() {
        return mesagem;
    }
}
