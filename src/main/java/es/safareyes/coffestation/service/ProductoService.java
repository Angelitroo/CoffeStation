package es.safareyes.coffestation.service;

import es.safareyes.coffestation.dto.ProductoDTO;
import es.safareyes.coffestation.dto.ProductoDTOcrear;
import es.safareyes.coffestation.model.Alergeno;
import es.safareyes.coffestation.model.Categoria;
import es.safareyes.coffestation.model.Producto;
import es.safareyes.coffestation.repository.AlergenoRepository;
import es.safareyes.coffestation.repository.CategoriaRepository;
import es.safareyes.coffestation.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private AlergenoRepository alergenoRepository;

    public List<ProductoDTO> getAllProductos(){
        return productoRepository.findAll().stream().map(this::convertToDTO).toList();
    }

    public List<Producto> getAllProductosFull(){
        return productoRepository.findAll();
    }

    public Producto getProductoById(Long id){
        return productoRepository.findById(id).orElse(null);
    }

    public ProductoDTO createProducto(ProductoDTOcrear productoDTO){
        Producto producto = new Producto();
        producto.setId(productoDTO.getId());
        producto.setNombre(productoDTO.getNombre());
        producto.setDescripcion(productoDTO.getDescripcion());
        producto.setPrecio(productoDTO.getPrecio());
        producto.setDisponible(productoDTO.getDisponible());
        producto.setActivo(productoDTO.getActivo());

        Categoria categoria = categoriaRepository.findById(productoDTO.getCategoriaId())
                .orElseThrow(() -> new IllegalArgumentException("Categoria no encontrada"));
        producto.setCategoria(categoria);

        List<Alergeno> alergenos = alergenoRepository.findAllById(productoDTO.getAlergenosIds());
        if (alergenos.size() != productoDTO.getAlergenosIds().size()) {
            throw new IllegalArgumentException("Uno o más IDs de alérgenos no son válidos");
        }
        producto.setAlergeno(alergenos);

        Producto savedProducto = productoRepository.save(producto);
        return convertToDTO(savedProducto);
    }

    public ProductoDTO updateProducto(ProductoDTO productoDTO, Long id){
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));

        producto.setNombre(productoDTO.getNombre());
        producto.setDescripcion(productoDTO.getDescripcion());
        producto.setPrecio(productoDTO.getPrecio());
        producto.setDisponible(productoDTO.getDisponible());
        producto.setActivo(productoDTO.getActivo());

        Producto productoUpdated = productoRepository.save(producto);
        return convertToDTO(productoUpdated);
    }

    public ProductoDTO updateProductoDisponibilidad(Boolean disponible, Long id){
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));

        producto.setDisponible(disponible);

        Producto productoUpdated = productoRepository.save(producto);
        return convertToDTO(productoUpdated);
    }


    public ProductoDTO convertToDTO(Producto producto) {
        return new ProductoDTO(
                producto.getId(),
                producto.getNombre(),
                producto.getDescripcion(),
                producto.getPrecio(),
                producto.getDisponible(),
                producto.getActivo()
        );
    }
}
