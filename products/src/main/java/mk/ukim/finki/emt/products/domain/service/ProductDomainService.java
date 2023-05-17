package mk.ukim.finki.emt.products.domain.service;

import mk.ukim.finki.emt.products.domain.models.Product;
import mk.ukim.finki.emt.products.services.form.ProductForm;
import org.springframework.stereotype.Service;

@Service
public class ProductDomainService {

    public Product toDomainObject(ProductForm form) {
        return new Product(form.getEmployeeId(), form.getName(), form.getStorageDate(), form.getPurchasedPrice());
    }
}
