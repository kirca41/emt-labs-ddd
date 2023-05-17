package mk.ukim.finki.emt.products.services.form;

import lombok.Data;
import mk.finki.ukim.emt.sharedkernel.domain.financial.Money;
import mk.ukim.finki.emt.products.domain.valueobjects.EmployeeId;

import java.time.LocalDateTime;

@Data
public class ProductForm {

    private String name;
    private LocalDateTime storageDate;
    private Money purchasedPrice;
    private EmployeeId employeeId;
}
