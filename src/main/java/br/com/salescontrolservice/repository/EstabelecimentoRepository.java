package br.com.salescontrolservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.salescontrolservice.domain.entity.Estabelecimento;

@Repository
public interface EstabelecimentoRepository extends JpaRepository<Estabelecimento, Integer> {
	
	boolean existsEstabelecimentoByNome(final String nome);
	
	Iterable<Estabelecimento> findAllByOrderByIdDesc();
}

