package mk.ukim.finki.emt.products.domain.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import mk.finki.ukim.emt.sharedkernel.domain.base.AbstractEntity;
import mk.finki.ukim.emt.sharedkernel.domain.base.DomainObjectId;
import mk.finki.ukim.emt.sharedkernel.domain.financial.Money;
import mk.ukim.finki.emt.products.domain.valueobjects.EmployeeId;

import java.time.LocalDateTime;

@Entity
@Table(name = "product")
@Getter
public class Product extends AbstractEntity<ProductId> {

    private String name;

    private LocalDateTime storageDate;

    @AttributeOverrides({
            @AttributeOverride(name = "amount", column = @Column(name = "purchased_price_amount")),
            @AttributeOverride(name = "currency", column = @Column(name = "purchased_price_currency"))
    })
    private Money purchasedPrice;

    @AttributeOverride(name = "id", column = @Column(name = "employee_id", nullable = false))
    private EmployeeId employeeId;

    private Product() {
        super(DomainObjectId.randomId(ProductId.class));
    }

    public Product(@NonNull EmployeeId employeeId,
                   @NonNull String name,
                   @NonNull LocalDateTime storageDate,
                   @NonNull Money purchasedPrice) {
        super(DomainObjectId.randomId(ProductId.class));
        this.employeeId = employeeId;
        this.name = name;
        this.storageDate = storageDate;
        this.purchasedPrice = purchasedPrice;
    }

}
