package es.safareyes.coffestation.dto;

import es.safareyes.coffestation.enums.Estado;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDTO {
    private Long id;
    private Estado estado;
    private Integer maxUsos;
}
