package mk.finki.ukim.emt.sales.domain.repository;

import mk.finki.ukim.emt.sales.domain.models.Sale;
import mk.finki.ukim.emt.sales.domain.models.SaleId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, SaleId> {
}
