package es.safareyes.coffestation.controller;

import es.safareyes.coffestation.dto.ProductoDTO;
import es.safareyes.coffestation.dto.ProductoDTOcrear;
import es.safareyes.coffestation.model.Producto;
import es.safareyes.coffestation.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public ResponseEntity<List<ProductoDTO>> getAllProductos(){
        return ResponseEntity.ok(productoService.getAllProductos());
    }

    @GetMapping("/full")
    public ResponseEntity<List<Producto>> getAllProductosFull(){
        return ResponseEntity.ok(productoService.getAllProductosFull());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> getProductoById(@PathVariable Long id){
        return ResponseEntity.ok(productoService.getProductoById(id));
    }

    @PostMapping
    public ResponseEntity<ProductoDTO> createProducto(@RequestBody ProductoDTOcrear productoDTOcrear){
        return ResponseEntity.ok(productoService.createProducto(productoDTOcrear));
    }


}
