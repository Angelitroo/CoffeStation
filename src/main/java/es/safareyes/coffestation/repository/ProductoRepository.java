package es.safareyes.coffestation.repository;

import es.safareyes.coffestation.model.Categoria;
import es.safareyes.coffestation.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
Buscar productos por categoría, texto en el nombre, precio
máximo, disponibilidad y excluyendo un alérgeno, con
paginación.
 */
@Repository
public interface ProductoRepository extends JpaRepository <Producto, Long> {
    List<Producto> findAllByCategoria(Categoria categoria);

    List<Producto> findByNombreContainingIgnoreCase(String texto);

    @Query("SELECT p FROM Producto p WHERE p.precio = (SELECT MAX(p2.precio) FROM Producto p2)")
    List<Producto> findProductoConPrecioMaximo();

    List<Producto> findAllByDisponibleEquals(Boolean disponible);

    @Query("SELECT p FROM Producto p WHERE NOT EXISTS (SELECT 1 FROM p.alergeno a WHERE a.nombre = :nombreAlergeno)")
    public List<Producto> findProductosSinAlergeno(String nombreAlergeno);


}
