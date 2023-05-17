package mk.ukim.finki.emt.employees.service;

import mk.finki.ukim.emt.sharedkernel.domain.financial.Currency;
import mk.finki.ukim.emt.sharedkernel.domain.financial.Money;
import mk.ukim.finki.emt.employees.domain.models.Employee;
import mk.ukim.finki.emt.employees.domain.repository.EmployeeRepository;
import mk.ukim.finki.emt.employees.domain.service.EmployeeDomainService;
import mk.ukim.finki.emt.employees.services.EmployeeService;
import mk.ukim.finki.emt.employees.services.form.EmployeeForm;
import mk.ukim.finki.emt.employees.services.impl.EmployeeServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceImplMockitoTests {

    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private EmployeeDomainService employeeDomainService;

    private EmployeeService employeeService;

    // MockitoExtension does not implement BeforeAllCallback, so can't use @BeforeAll
    @BeforeEach
    public void init() {
        Employee employee = Employee.build("Kiril", "Kovacheski", Money.valueOf(Currency.USD, 700));
        Mockito.when(this.employeeRepository.saveAndFlush(Mockito.any(Employee.class))).thenReturn(employee);
        Mockito.when(this.employeeDomainService.toDomainObject(Mockito.any(EmployeeForm.class))).thenReturn(employee);
        this.employeeService = Mockito.spy(new EmployeeServiceImpl(this.employeeRepository, employeeDomainService));
    }


    @Test
    public void createEmployee() {
        EmployeeForm form = new EmployeeForm();
        form.setName("Kiril");
        form.setSurname("Kovacheski");
        form.setBaseSalary(Money.valueOf(Currency.USD, 700));

        Employee employee = this.employeeService.createEmployee(form);

        Mockito.verify(this.employeeService).createEmployee(form);

        Assertions.assertEquals("Kiril", employee.getName(), "Names do not match!");
        Assertions.assertEquals("Kovacheski", employee.getSurname(), "Surnames do not match!");
        Assertions.assertEquals(Money.valueOf(Currency.USD, 700), employee.getBaseSalary(), "Salaries do not match!");
    }
}
