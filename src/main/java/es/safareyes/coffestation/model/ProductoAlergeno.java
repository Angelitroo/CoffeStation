package es.safareyes.coffestation.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "producto_alergeno")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoAlergeno {
    @Id
    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto producto;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_alergeno", nullable = false)
    private Alergeno alergeno;

}
