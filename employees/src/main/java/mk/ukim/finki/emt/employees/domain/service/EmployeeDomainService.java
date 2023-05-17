package mk.ukim.finki.emt.employees.domain.service;

import mk.ukim.finki.emt.employees.domain.models.Employee;
import mk.ukim.finki.emt.employees.services.form.EmployeeForm;
import org.springframework.stereotype.Service;

@Service
public class EmployeeDomainService {

    public Employee toDomainObject(EmployeeForm employeeForm) {
        return Employee.build(employeeForm.getName(), employeeForm.getSurname(), employeeForm.getBaseSalary());
    }
}
