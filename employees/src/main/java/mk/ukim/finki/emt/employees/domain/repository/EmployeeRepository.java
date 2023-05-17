package mk.ukim.finki.emt.employees.domain.repository;

import mk.ukim.finki.emt.employees.domain.models.Employee;
import mk.ukim.finki.emt.employees.domain.models.EmployeeId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, EmployeeId> {
}
