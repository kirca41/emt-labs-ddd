package mk.ukim.finki.emt.products.services.impl;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.products.domain.exceptions.InvalidProductIdException;
import mk.ukim.finki.emt.products.domain.models.Product;
import mk.ukim.finki.emt.products.domain.models.ProductId;
import mk.ukim.finki.emt.products.domain.repository.ProductRepository;
import mk.ukim.finki.emt.products.domain.service.ProductDomainService;
import mk.ukim.finki.emt.products.services.ProductService;
import mk.ukim.finki.emt.products.services.form.ProductForm;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private ProductDomainService productDomainService;

    @Override
    public Product findById(ProductId id) {
        return this.productRepository.findById(id)
                .orElseThrow(() -> new InvalidProductIdException("Product Id does not exist"));
    }

    @Override
    public Product createProduct(ProductForm form) {
        Objects.requireNonNull(form, "Product must not be null!");
        return this.productRepository.saveAndFlush(this.productDomainService.toDomainObject(form));
    }

    @Override
    public List<Product> getAll() {
        return this.productRepository.findAll();
    }
}
