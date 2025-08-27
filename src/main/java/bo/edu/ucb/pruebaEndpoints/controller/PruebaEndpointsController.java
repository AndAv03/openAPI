package bo.edu.ucb.pruebaEndpoints.controller;
// LINK http://localhost:8080/swagger-ui.html

import bo.edu.ucb.pruebaEndpoints.dto.ProductDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/product")
@Tag(name = "Productos", description = "Operaciones sobre productos del inventario")
public class PruebaEndpointsController {

    // "Base de datos" en memoria
    private static List<ProductDto> inventory = new ArrayList<>();

    static {
        inventory.add(new ProductDto(1, "Hamburguesa Clásica", 25.0, "Plato Principal", 15));
        inventory.add(new ProductDto(2, "Jugo de Naranja Natural", 10.0, "Bebida", 30));
        inventory.add(new ProductDto(3, "Cheesecake de Frutilla", 18.5, "Postre", 8));
        inventory.add(new ProductDto(4, "Pizza Margarita",40.0,"Plato principal", 10));
        inventory.add(new ProductDto(5,"Ensalada Cesar",22.0,"Entrada",12));
        inventory.add(new ProductDto(6,"Cafe espresso",8.0,"Bebida",25 ));
    }

    // GET todos

    @Operation(summary = "Obtener todos los productos", description = "Devuelve la lista completa de productos en el inventario")
    @ApiResponse(responseCode = "200", description = "Lista de productos obtenida correctamente")
    @GetMapping
    public List<ProductDto> getProducts() {
        return inventory;
    }

    // GET por ID

    @Operation(summary = "Obtener producto por ID", description = "Devuelve un producto específico según su ID")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Producto encontrado"),
        @ApiResponse(responseCode = "404", description = "Producto no encontrado")
    })
    @GetMapping("/{id}")
    public ProductDto getProductById(@Parameter(description = "ID del producto a buscar") @PathVariable int id) {
        return inventory.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // POST -> agregar producto

    @Operation(summary = "Agregar un nuevo producto", description = "Agrega un producto al inventario")
    @ApiResponse(responseCode = "201", description = "Producto agregado correctamente")
    @PostMapping
    public ProductDto addProduct(@RequestBody ProductDto newProduct) {
        inventory.add(newProduct);
        return newProduct;
    }

    // PUT -> actualizar producto

    @Operation(summary = "Actualizar producto", description = "Actualiza los datos de un producto existente")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Producto actualizado correctamente"),
        @ApiResponse(responseCode = "404", description = "Producto no encontrado")
    })
    @PutMapping("/{id}")
    public ProductDto updateProduct(@Parameter(description = "ID del producto a actualizar") @PathVariable int id, @RequestBody ProductDto updatedProduct) {
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getId() == id) {
                inventory.set(i, updatedProduct);
                return updatedProduct;
            }
        }
        return null;
    }

    // DELETE -> eliminar producto

    @Operation(summary = "Eliminar producto", description = "Elimina un producto del inventario por su ID")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Producto eliminado"),
        @ApiResponse(responseCode = "404", description = "Producto no encontrado")
    })
    @DeleteMapping("/{id}")
    public String deleteProduct(@Parameter(description = "ID del producto a eliminar") @PathVariable int id) {
        boolean removed = inventory.removeIf(p -> p.getId() == id);
        return removed ? "Producto eliminado" : "Producto no encontrado";
    }
}
