package es.safareyes.coffestation.service;

import es.safareyes.coffestation.dto.PedidoDTO;
import es.safareyes.coffestation.enums.Estado;
import es.safareyes.coffestation.model.Pedido;
import es.safareyes.coffestation.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> getAllPedidos(){
        return pedidoRepository.findAll();
    }

    public Pedido getPedidoById(Long id){
        return pedidoRepository.findById(id).orElse(null);
    }

    public Pedido updatePedidoEstado(Long id, PedidoDTO pedidoDTO) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pedido no encontrado"));
        pedido.setEstado(pedidoDTO.getEstado());
        return pedidoRepository.save(pedido);
    }

}
