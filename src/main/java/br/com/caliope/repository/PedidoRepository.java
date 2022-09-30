package br.com.caliope.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.caliope.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
