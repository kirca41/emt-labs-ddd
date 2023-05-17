package mk.finki.ukim.emt.sales.services;

import mk.finki.ukim.emt.sales.domain.models.Sale;
import mk.finki.ukim.emt.sales.domain.models.SaleId;
import mk.finki.ukim.emt.sales.services.form.SaleForm;

import java.util.List;

public interface SaleService {

    Sale findById(SaleId id);
    Sale createSale(SaleForm form);
    List<Sale> getAll();
}
