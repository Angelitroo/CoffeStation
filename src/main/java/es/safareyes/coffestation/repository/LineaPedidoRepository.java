package es.safareyes.coffestation.repository;

import es.safareyes.coffestation.model.LineaPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LineaPedidoRepository extends JpaRepository <LineaPedido, Long> {
}
