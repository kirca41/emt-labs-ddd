package mk.ukim.finki.emt.employees.domain.models;

import jakarta.persistence.*;
import lombok.Getter;
import mk.finki.ukim.emt.sharedkernel.domain.base.AbstractEntity;
import mk.finki.ukim.emt.sharedkernel.domain.financial.Money;

@Entity
@Table(name = "employee")
@Getter
public class Employee extends AbstractEntity<EmployeeId> {

    private String name;

    private String surname;

    @AttributeOverrides({
            @AttributeOverride(name = "amount", column = @Column(name = "base_salary_amount")),
            @AttributeOverride(name = "currency", column = @Column(name = "base_salary_currency"))
    })
    private Money baseSalary;

    private Employee() {
        super(EmployeeId.randomId(EmployeeId.class));
    }

    public static Employee build(String name, String surname, Money baseSalary) {
        Employee e = new Employee();
        e.name = name;
        e.surname = surname;
        e.baseSalary = baseSalary;

        return e;
    }
}
