package br.com.salescontrolservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.salescontrolservice.domain.entity.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	boolean existsProdutoByDescricao(final String descricao);
	
	List<Produto> findAllByOrderByIdDesc();
}
