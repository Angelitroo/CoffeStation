package es.safareyes.coffestation.repository;

import es.safareyes.coffestation.model.Alergeno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlergenoRepository extends JpaRepository <Alergeno, Long> {
}
