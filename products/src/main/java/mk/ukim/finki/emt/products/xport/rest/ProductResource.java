package mk.ukim.finki.emt.products.xport.rest;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.products.domain.models.Product;
import mk.ukim.finki.emt.products.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductResource {

    private ProductService productService;

    @GetMapping
    public List<Product> getAll() {
        return this.productService.getAll();
    }
}
