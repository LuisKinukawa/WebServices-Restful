package br.com.fiap.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.springboot.domain.PontosColeta;

@Repository
public interface PontoColetaRepository extends JpaRepository<PontosColeta, Integer> {

}
