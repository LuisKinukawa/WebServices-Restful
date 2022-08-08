package br.com.fiap.springboot.repository;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.springboot.domain.*;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

	List<Produto> findByNome(String prod); 

    List<Produto> findByPesoGreaterThan(double peso);

	
}
