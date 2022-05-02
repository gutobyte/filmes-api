package com.gustavo.filmes.filmesapi.repository;

import com.gustavo.filmes.filmesapi.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository("FilmeRepository")
public interface FilmeRepository extends JpaRepository<Filme, Long> {
}
