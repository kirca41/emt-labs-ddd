package mk.finki.ukim.emt.sales.services.form;

import lombok.Data;
import mk.finki.ukim.emt.sales.domain.valueobjects.Employee;
import mk.finki.ukim.emt.sales.domain.valueobjects.Product;

import java.time.LocalDateTime;

@Data
public class SaleForm {

    private LocalDateTime soldOn;
    private int quantity;
    private Product product;
    private Employee employee;

}
