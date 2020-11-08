package br.com.salescontrolservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.salescontrolservice.domain.entity.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

	Iterable<Pedido> findAllByOrderByIdDesc();
	
}

