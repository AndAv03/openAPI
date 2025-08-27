
package bo.edu.ucb.pruebaEndpoints.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO que representa un producto del inventario")
public class ProductDto {
    @Schema(description = "ID único del producto", example = "1")
    private int id;

    @Schema(description = "Nombre del producto", example = "Hamburguesa Clásica")
    private String nombre;

    @Schema(description = "Precio del producto", example = "25.0")
    private double precio;

    @Schema(description = "Categoría del producto", example = "Plato Principal")
    private String categoria;

    @Schema(description = "Cantidad disponible en stock", example = "15")
    private int stock;

    // Constructor vacío (necesario para deserializar JSON)
    public ProductDto() {}

    public ProductDto(int id, String nombre, double precio, String categoria, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
        this.stock = stock;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }
}