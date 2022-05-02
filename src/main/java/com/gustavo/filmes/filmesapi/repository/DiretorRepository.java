package com.gustavo.filmes.filmesapi.repository;

import com.gustavo.filmes.filmesapi.model.Diretor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("DiretorRepository")
public interface DiretorRepository extends JpaRepository<Diretor, Long> {

    Diretor findByNome(String nome);
}
