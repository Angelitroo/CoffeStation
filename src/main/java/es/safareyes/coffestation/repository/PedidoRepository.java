package es.safareyes.coffestation.repository;

import es.safareyes.coffestation.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository <Pedido, Long> {

    @Query("select count(p) from Pedido p where p.cupon.codigo = ?1")
    Integer findByCupon_Codigo(String codigo);

}

