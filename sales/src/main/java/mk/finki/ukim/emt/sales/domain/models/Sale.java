package mk.finki.ukim.emt.sales.domain.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import mk.finki.ukim.emt.sales.domain.config.ProfitPercentageHolder;
import mk.finki.ukim.emt.sales.domain.exceptions.InvalidSaleDateException;
import mk.finki.ukim.emt.sales.domain.valueobjects.Employee;
import mk.finki.ukim.emt.sales.domain.valueobjects.EmployeeId;
import mk.finki.ukim.emt.sales.domain.valueobjects.Product;
import mk.finki.ukim.emt.sales.domain.valueobjects.ProductId;
import mk.finki.ukim.emt.sharedkernel.domain.base.AbstractEntity;
import mk.finki.ukim.emt.sharedkernel.domain.base.DomainObjectId;
import mk.finki.ukim.emt.sharedkernel.domain.financial.Money;

import java.time.LocalDateTime;

@Entity
@Table(name = "sale")
@Getter
public class Sale extends AbstractEntity<SaleId> {

    @AttributeOverrides({
            @AttributeOverride(name = "amount", column = @Column(name = "sale_price_amount")),
            @AttributeOverride(name = "currency", column = @Column(name = "sale_price_currency"))
    })
    private Money salePrice;

    private LocalDateTime soldOn;

    private int quantity;

    private ProductId productId;

    private EmployeeId employeeId;

    private Sale() {
        super(SaleId.randomId(SaleId.class));
    }

    private Sale(@NonNull Money salePrice, @NonNull LocalDateTime soldOn, int quantity,
                 @NonNull ProductId productId, @NonNull EmployeeId employeeId) {
        super(DomainObjectId.randomId(SaleId.class));
        this.salePrice = salePrice;
        this.soldOn = soldOn;
        this.quantity = quantity;
        this.productId = productId;
        this.employeeId = employeeId;
    }

    // Factory method better here because we check business rule
    public static Sale createSale(LocalDateTime soldOn, int quantity, Product product, Employee employee) {
        if (soldOn.isBefore(product.getStorageDate()))
            throw new InvalidSaleDateException("Sale date must not be before storage date!");

        return new Sale(product.getPurchasedPrice().increaseByPercentage(ProfitPercentageHolder.ORDINARY_PROFIT_PERCENTAGE),
                        soldOn,
                        quantity,
                        product.getId(),
                        employee.getId());
    }

    public Money subtotal() {
        return this.salePrice.multiply(this.quantity);
    }
}
