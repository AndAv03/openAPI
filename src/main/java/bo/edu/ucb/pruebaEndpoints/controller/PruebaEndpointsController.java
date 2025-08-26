package bo.edu.ucb.pruebaEndpoints.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PruebaEndpointsController {

    @GetMapping("api/v1/product")
    public List<Map<String, Object>> getProducts() {
        List<Map<String, Object>> list = new ArrayList<>();

        Map<String, Object> map1 = new HashMap<>();
        Map<String, Object> map2 = new HashMap<>();
        Map<String, Object> map3 = new HashMap<>();

        map1.put("id", 1);
        map1.put("name","Leche entera 1L");
        map1.put("precio",8.5);
        list.add(map1);

        map2.put("id", 2);
        map2.put("name","Pan Integral 500g");
        map2.put("precio",6);
        list.add(map2);

        map3.put("id", 3);
        map3.put("name","Arroz Blanco 1kg");
        map3.put("precio",12.3);
        list.add(map3);

        return list;

    }

}
