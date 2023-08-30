package tema.tema3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tema.tema3.entity.Product;
import tema.tema3.service.ProductService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("/add")
    public Product addProduct(Product product) {
        List<Product> produseHardcodate = new ArrayList<>();
        for (int i = 0; i < 10 ; i++) {
            Product prod = new Product();
            prod.setName("product" + i);
            produseHardcodate.add(prod);

        }
        for(Product p : produseHardcodate) {
            productService.addProduct(p);
        }


        return null;
        //non hardcoded version
        //return productService.addProduct(product);
    }

    @GetMapping("/all_products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();

    }
}
