package es.safareyes.coffestation.repository;

import es.safareyes.coffestation.model.Descuento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DescuentoRepository extends JpaRepository <Descuento, Long> {
}
