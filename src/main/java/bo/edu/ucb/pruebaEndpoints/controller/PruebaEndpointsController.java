package bo.edu.ucb.pruebaEndpoints.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PruebaEndpointsController {

    // Endpoint que devuelve todo el inventario
    @GetMapping("api/v1/product")
    public List<Map<String, Object>> getProducts() {
        return buildInventory();
    }

    // Endpoint que devuelve un producto específico por su id
    @GetMapping("api/v1/product/{id}")
    public Map<String, Object> getProductById(@PathVariable int id) {
        List<Map<String, Object>> productos = buildInventory();

        for (Map<String, Object> producto : productos) {
            if (producto.get("id").equals(id)) {
                return producto;
            }
        }

        // Si no se encuentra el producto, devolvemos un mensaje
        Map<String, Object> notFound = new HashMap<>();
        notFound.put("error", "Producto con id " + id + " no encontrado");
        return notFound;
    }

    // Método privado que simula el inventario del restaurante
    private List<Map<String, Object>> buildInventory() {
        List<Map<String, Object>> list = new ArrayList<>();

        Map<String, Object> p1 = new HashMap<>();
        p1.put("id", 1);
        p1.put("nombre", "Hamburguesa Clásica");
        p1.put("precio", 25.0);
        p1.put("categoria", "Plato Principal");
        p1.put("stock", 15);
        list.add(p1);

        Map<String, Object> p2 = new HashMap<>();
        p2.put("id", 2);
        p2.put("nombre", "Jugo de Naranja Natural");
        p2.put("precio", 10.0);
        p2.put("categoria", "Bebida");
        p2.put("stock", 30);
        list.add(p2);

        Map<String, Object> p3 = new HashMap<>();
        p3.put("id", 3);
        p3.put("nombre", "Cheesecake de Frutilla");
        p3.put("precio", 18.5);
        p3.put("categoria", "Postre");
        p3.put("stock", 8);
        list.add(p3);

        Map<String, Object> p4 = new HashMap<>();
        p4.put("id", 4);
        p4.put("nombre", "Pizza Margarita");
        p4.put("precio", 40.0);
        p4.put("categoria", "Plato Principal");
        p4.put("stock", 10);
        list.add(p4);

        Map<String, Object> p5 = new HashMap<>();
        p5.put("id", 5);
        p5.put("nombre", "Ensalada César");
        p5.put("precio", 22.0);
        p5.put("categoria", "Entrada");
        p5.put("stock", 12);
        list.add(p5);

        Map<String, Object> p6 = new HashMap<>();
        p6.put("id", 6);
        p6.put("nombre", "Café Espresso");
        p6.put("precio", 8.0);
        p6.put("categoria", "Bebida");
        p6.put("stock", 25);
        list.add(p6);

        return list;
    }
}
