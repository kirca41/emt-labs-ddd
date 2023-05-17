package mk.ukim.finki.emt.employees.xport.rest;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.employees.domain.models.Employee;
import mk.ukim.finki.emt.employees.services.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeResource {

    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAll() {
        return this.employeeService.getAll();
    }
}
