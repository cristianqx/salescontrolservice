package br.com.salescontrolservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.salescontrolservice.domain.entity.ItemPedido;
import br.com.salescontrolservice.domain.entity.Pedido;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer> {

	Iterable<ItemPedido> findAllByOrderByIdDesc();
	
	@Query("SELECT i FROM ItemPedido i "
			+ "JOIN FETCH i.id p "
			+ "WHERE p.pedido = :pedido")
	List<ItemPedido> findByPedido(final Pedido pedido);
	
}

