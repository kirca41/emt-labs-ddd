package mk.ukim.finki.emt.products.domain.repository;

import mk.ukim.finki.emt.products.domain.models.Product;
import mk.ukim.finki.emt.products.domain.models.ProductId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, ProductId> {
}
