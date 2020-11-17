package br.com.salescontrolservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import br.com.salescontrolservice.domain.entity.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
	boolean existsProdutoByDescricaoAndEstabelecimentoId(final String descricao, final Integer idEstabelecimento);
	
	Iterable<Produto> findAllByEstabelecimentoIdOrderByIdDesc(Integer idEstabelecimento);

	@Query("SELECT p FROM Produto p "
			+ "JOIN FETCH p.estabelecimento e "
			+ "WHERE e.id = :estabelecimentoId "
			+ "AND p.descricao LIKE %:descricao%")
	Iterable<Produto> findByEstabelecimentoIdAndDescricao(@Param("estabelecimentoId") Integer estabelecimentoId, @Param("descricao") String descricao);
}
