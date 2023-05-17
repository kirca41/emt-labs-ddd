package mk.ukim.finki.emt.employees.services;

import mk.ukim.finki.emt.employees.domain.models.Employee;
import mk.ukim.finki.emt.employees.domain.models.EmployeeId;
import mk.ukim.finki.emt.employees.services.form.EmployeeForm;

import java.util.List;

public interface EmployeeService {

    Employee findById(EmployeeId id);
    Employee createEmployee(EmployeeForm form);
    List<Employee> getAll();
}
