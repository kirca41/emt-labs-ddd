package mk.ukim.finki.emt.employees.services.impl;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.employees.domain.exceptions.InvalidEmployeeIdException;
import mk.ukim.finki.emt.employees.domain.models.Employee;
import mk.ukim.finki.emt.employees.domain.models.EmployeeId;
import mk.ukim.finki.emt.employees.domain.repository.EmployeeRepository;
import mk.ukim.finki.emt.employees.domain.service.EmployeeDomainService;
import mk.ukim.finki.emt.employees.services.EmployeeService;
import mk.ukim.finki.emt.employees.services.form.EmployeeForm;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private EmployeeDomainService employeeDomainService;

    @Override
    public Employee findById(EmployeeId id) {
        return this.employeeRepository.findById(id)
                .orElseThrow(() -> new InvalidEmployeeIdException("Employee Id does not exist"));
    }

    @Override
    public Employee createEmployee(EmployeeForm form) {
        Objects.requireNonNull(form, "Employee must not be null!");
        return this.employeeRepository.saveAndFlush(employeeDomainService.toDomainObject(form));
    }

    @Override
    public List<Employee> getAll() {
        return this.employeeRepository.findAll();
    }
}
