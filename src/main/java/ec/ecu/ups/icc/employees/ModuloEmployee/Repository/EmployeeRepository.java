package ec.ecu.ups.icc.employees.ModuloEmployee.Repository;

import ec.ecu.ups.icc.employees.ModuloEmployee.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
    Optional<Employee> findByIdAndActive(Long id, Character active);
}