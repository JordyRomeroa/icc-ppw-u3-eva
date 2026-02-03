package ec.ecu.ups.icc.employees.ModuloDepartment.Service;

import ec.ecu.ups.icc.employees.ModuloDepartment.Dto.DepartmentWithEmployeesDto;
import ec.ecu.ups.icc.employees.ModuloDepartment.Dto.CompanySimpleDto;
import ec.ecu.ups.icc.employees.ModuloDepartment.Dto.EmployeeSimpleDto;
import ec.ecu.ups.icc.employees.ModuloDepartment.Entity.Department;
import ec.ecu.ups.icc.employees.ModuloDepartment.Repository.DepartmentRepository;
import ec.ecu.ups.icc.employees.ModuloEmployee.Entity.Employee;
import ec.ecu.ups.icc.employees.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public DepartmentWithEmployeesDto getDepartmentWithEmployees(Long id, String sort) {
        Department dept = departmentRepository.findByIdAndActive(id, 'S')
                .orElseThrow(() -> new ResourceNotFoundException("Department not found or inactive"));

        Comparator<Employee> comparator = Comparator.comparing(Employee::getSalary);
        if (sort == null || sort.equalsIgnoreCase("desc")) {
            comparator = comparator.reversed();
        }

        List<EmployeeSimpleDto> employeeDtos = dept.getEmployees().stream()
                .filter(e -> e.getActive() == 'S')
                .sorted(comparator)
                .map(this::mapToEmployeeSimple)
                .collect(Collectors.toList());

        Double totalSalaries = employeeDtos.stream()
                .mapToDouble(EmployeeSimpleDto::getSalary)
                .sum();

        CompanySimpleDto companyDto = new CompanySimpleDto();
        companyDto.setId(dept.getCompany().getId());
        companyDto.setName(dept.getCompany().getName());
        companyDto.setCountry(dept.getCompany().getCountry());

        DepartmentWithEmployeesDto response = new DepartmentWithEmployeesDto();
        response.setId(dept.getId());
        response.setName(dept.getName());
        response.setBudget(dept.getBudget());
        response.setCompany(companyDto);
        response.setEmployees(employeeDtos);
        response.setEmployeeCount(employeeDtos.size());
        response.setTotalSalaries(totalSalaries);

        return response;
    }

    private EmployeeSimpleDto mapToEmployeeSimple(Employee emp) {
        EmployeeSimpleDto dto = new EmployeeSimpleDto();
        dto.setId(emp.getId());
        dto.setFirstName(emp.getFirstName());
        dto.setLastName(emp.getLastName());
        dto.setEmail(emp.getEmail());
        dto.setSalary(emp.getSalary());
        return dto;
    }
}