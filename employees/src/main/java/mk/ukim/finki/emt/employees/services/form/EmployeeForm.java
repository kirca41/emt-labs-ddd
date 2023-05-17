package mk.ukim.finki.emt.employees.services.form;

import lombok.Data;
import mk.finki.ukim.emt.sharedkernel.domain.financial.Money;

@Data
public class EmployeeForm {

    private String name;
    private String surname;
    private Money baseSalary;

}
