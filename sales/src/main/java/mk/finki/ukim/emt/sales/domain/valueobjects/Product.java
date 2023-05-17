package mk.finki.ukim.emt.sales.domain.valueobjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import mk.finki.ukim.emt.sharedkernel.domain.base.ValueObject;
import mk.finki.ukim.emt.sharedkernel.domain.financial.Currency;
import mk.finki.ukim.emt.sharedkernel.domain.financial.Money;

import java.time.LocalDateTime;

@Getter
public class Product implements ValueObject {

    private ProductId id;
    private Money purchasedPrice;
    private LocalDateTime storageDate;

    // Don't need this for now
//    private EmployeeId employeeId;
//    private String name;


    private Product() {
        this.id = ProductId.randomId(ProductId.class);
        this.purchasedPrice = Money.valueOf(Currency.USD,0);
        this.storageDate = LocalDateTime.now();
    }

    @JsonCreator
    private Product(@JsonProperty("id") ProductId id,
                   @JsonProperty("baseSalary") Money purchasedPrice,
                   @JsonProperty("storageDate") LocalDateTime storageDate) {
        this.id = id;
        this.purchasedPrice = purchasedPrice;
        this.storageDate = storageDate;
    }
}
