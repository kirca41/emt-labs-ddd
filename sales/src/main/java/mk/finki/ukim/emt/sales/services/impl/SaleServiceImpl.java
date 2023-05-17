package mk.finki.ukim.emt.sales.services.impl;

import lombok.AllArgsConstructor;
import mk.finki.ukim.emt.sales.domain.exceptions.InvalidSaleIdException;
import mk.finki.ukim.emt.sales.domain.models.Sale;
import mk.finki.ukim.emt.sales.domain.models.SaleId;
import mk.finki.ukim.emt.sales.domain.repository.SaleRepository;
import mk.finki.ukim.emt.sales.domain.service.SaleDomainService;
import mk.finki.ukim.emt.sales.services.SaleService;
import mk.finki.ukim.emt.sales.services.form.SaleForm;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
@AllArgsConstructor
public class SaleServiceImpl implements SaleService {

    private SaleRepository saleRepository;
    private SaleDomainService saleDomainService;

    @Override
    public Sale findById(SaleId id) {
        return this.saleRepository.findById(id)
                .orElseThrow(() -> new InvalidSaleIdException("Sale Id does not exist"));
    }

    @Override
    public Sale createSale(SaleForm form) {
        Objects.requireNonNull(form);
        return this.saleRepository.saveAndFlush(this.saleDomainService.toDomainObject(form));
    }

    @Override
    public List<Sale> getAll() {
        return this.saleRepository.findAll();
    }
}
