package mk.ukim.finki.emt.products.services;

import mk.ukim.finki.emt.products.domain.models.Product;
import mk.ukim.finki.emt.products.domain.models.ProductId;
import mk.ukim.finki.emt.products.services.form.ProductForm;

import java.util.List;

public interface ProductService {

    Product findById(ProductId id);
    Product createProduct(ProductForm form);
    List<Product> getAll();
}
