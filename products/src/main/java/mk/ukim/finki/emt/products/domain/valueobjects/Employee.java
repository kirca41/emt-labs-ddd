package mk.ukim.finki.emt.products.domain.valueobjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import mk.finki.ukim.emt.sharedkernel.domain.base.ValueObject;
import mk.finki.ukim.emt.sharedkernel.domain.financial.Currency;
import mk.finki.ukim.emt.sharedkernel.domain.financial.Money;

@Getter
public class Employee implements ValueObject {

    private EmployeeId id;
    private String name;
    private String surname;
    private Money baseSalary;

    private Employee() {
        this.id = EmployeeId.randomId(EmployeeId.class);
        this.name = "";
        this.surname = "";
        this.baseSalary = Money.valueOf(Currency.USD,0);
    }

    @JsonCreator
    public Employee(@JsonProperty("id") EmployeeId id,
                   @JsonProperty("name") String name,
                   @JsonProperty("surname") String surname,
                   @JsonProperty("baseSalary") Money baseSalary) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.baseSalary = baseSalary;
    }

}
