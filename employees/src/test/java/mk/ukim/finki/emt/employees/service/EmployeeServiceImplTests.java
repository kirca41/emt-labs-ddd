package mk.ukim.finki.emt.employees.service;

import mk.finki.ukim.emt.sharedkernel.domain.financial.Currency;
import mk.finki.ukim.emt.sharedkernel.domain.financial.Money;
import mk.ukim.finki.emt.employees.domain.models.Employee;
import mk.ukim.finki.emt.employees.services.EmployeeService;
import mk.ukim.finki.emt.employees.services.form.EmployeeForm;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmployeeServiceImplTests {

    @Autowired
    private EmployeeService employeeService;

    @Test
    public void testCreateEmployee() {
        EmployeeForm form = new EmployeeForm();
        form.setName("Kiril");
        form.setSurname("Kovacheski");
        form.setBaseSalary(Money.valueOf(Currency.USD, 700));

        Employee employee = this.employeeService.createEmployee(form);
        Assertions.assertEquals("Kiril", employee.getName(), "Names do not match!");
        Assertions.assertEquals("Kovacheski", employee.getSurname(), "Surnames do not match!");
        Assertions.assertEquals(Money.valueOf(Currency.USD, 700), employee.getBaseSalary(), "Salaries do not match!");
    }

    @Test
    public void testCreateEmployeeNull() {
        Assertions.assertThrows(NullPointerException.class, () -> this.employeeService.createEmployee(null));
    }
}
