package mk.finki.ukim.emt.sales.domain.service;

import mk.finki.ukim.emt.sales.domain.models.Sale;
import mk.finki.ukim.emt.sales.services.form.SaleForm;
import org.springframework.stereotype.Service;

@Service
public class SaleDomainService {

    public Sale toDomainObject(SaleForm form) {
        return Sale.createSale(form.getSoldOn(), form.getQuantity(), form.getProduct(), form.getEmployee());
    }
}
