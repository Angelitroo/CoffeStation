package es.safareyes.coffestation.repository;

import es.safareyes.coffestation.model.Categoria;
import es.safareyes.coffestation.model.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/*
Buscar productos por categoría, texto en el nombre, precio
máximo, disponibilidad y excluyendo un alérgeno, con
paginación.
 */
@Repository
public interface ProductoRepository extends JpaRepository <Producto, Long> {
    Page<Producto> findAllByCategoria(Categoria categoria, Pageable pageable);

    Page<Producto> findByNombreContainingIgnoreCase(String texto, Pageable pageable);

    @Query("SELECT p FROM Producto p WHERE p.precio = (SELECT MAX(p2.precio) FROM Producto p2)")
    Page<Producto> findProductoConPrecioMaximo(Pageable pageable);

    Page<Producto> findAllByDisponibleEquals(Boolean disponible, Pageable pageable);

    @Query("SELECT p FROM Producto p WHERE NOT EXISTS (SELECT 1 FROM p.alergeno a WHERE a.nombre = :nombreAlergeno)")
    Page<Producto> findProductosSinAlergeno(String nombreAlergeno, Pageable pageable);

    @Query("SELECT p FROM Producto p WHERE EXISTS (SELECT 1 FROM p.alergeno a WHERE a.nombre = :nombreAlergeno)")
    Page<Producto> findProductosConAlergeno(String nombreAlergeno, Pageable pageable);

    //Ranking de productos más vendidos
    @Query("SELECT p FROM Producto p " +
            "JOIN LineaPedido lp ON p.id = lp.producto.id " +
            "GROUP BY p.id " +
            "ORDER BY SUM(lp.cantidad) DESC")
    Page<Producto> findProductosMasVendidos(Pageable pageable);



}
