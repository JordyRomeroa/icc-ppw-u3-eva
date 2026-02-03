package ec.ecu.ups.icc.employees.ModuloCompany.Service;

import ec.ecu.ups.icc.employees.ModuloCompany.Dto.CompanyDepartmentsDto;
import ec.ecu.ups.icc.employees.ModuloCompany.Dto.DepartmentSummaryDto;
import ec.ecu.ups.icc.employees.ModuloCompany.Dto.EmployeesResponseDto;
import ec.ecu.ups.icc.employees.ModuloCompany.Dto.EmployeeDetailDto;
import ec.ecu.ups.icc.employees.ModuloCompany.Dto.DepartmentSimpleDto;
import ec.ecu.ups.icc.employees.ModuloCompany.Entity.Company;
import ec.ecu.ups.icc.employees.ModuloCompany.Repository.CompanyRepository;
import ec.ecu.ups.icc.employees.ModuloDepartment.Entity.Department;
import ec.ecu.ups.icc.employees.ModuloEmployee.Entity.Employee;
import ec.ecu.ups.icc.employees.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public CompanyDepartmentsDto getCompanyDepartments(Long id) {
        Company company = companyRepository.findByIdAndActive(id, 'S')
                .orElseThrow(() -> new ResourceNotFoundException("Company not found or inactive"));

        List<DepartmentSummaryDto> departmentDtos = company.getDepartments().stream()
                .filter(d -> d.getActive() == 'S')
                .map(this::mapToDepartmentSummary)
                .collect(Collectors.toList());

        Double totalBudget = departmentDtos.stream()
                .mapToDouble(DepartmentSummaryDto::getBudget)
                .sum();

        CompanyDepartmentsDto response = new CompanyDepartmentsDto();
        response.setCompanyId(company.getId());
        response.setCompanyName(company.getName());
        response.setCountry(company.getCountry());
        response.setDepartments(departmentDtos);
        response.setDepartmentCount(departmentDtos.size());
        response.setTotalBudget(totalBudget);

        return response;
    }

    public EmployeesResponseDto getHighSalaryEmployees(Long id, Double minSalary) {
        Company company = companyRepository.findByIdAndActive(id, 'S')
                .orElseThrow(() -> new ResourceNotFoundException("Company not found or inactive"));
        
        Double threshold = (minSalary != null) ? minSalary : 5000.00;

        List<EmployeeDetailDto> employees = company.getDepartments().stream()
                .filter(d -> d.getActive() == 'S')
                .flatMap(d -> d.getEmployees().stream())
                .filter(e -> e.getActive() == 'S' && e.getSalary() >= threshold)
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .map(this::mapToEmployeeDetail)
                .collect(Collectors.toList());

        EmployeesResponseDto response = new EmployeesResponseDto();
        response.setCompanyName(company.getName());
        response.setMinSalary(threshold);
        response.setEmployees(employees);
        response.setCount(employees.size());

        return response;
    }

    private DepartmentSummaryDto mapToDepartmentSummary(Department dept) {
        int activeEmpCount = (int) dept.getEmployees().stream()
                .filter(e -> e.getActive() == 'S')
                .count();

        DepartmentSummaryDto dto = new DepartmentSummaryDto();
        dto.setId(dept.getId());
        dto.setName(dept.getName());
        dto.setBudget(dept.getBudget());
        dto.setEmployeeCount(activeEmpCount);
        return dto;
    }

    private EmployeeDetailDto mapToEmployeeDetail(Employee emp) {
        DepartmentSimpleDto deptDto = new DepartmentSimpleDto();
        deptDto.setId(emp.getDepartment().getId());
        deptDto.setName(emp.getDepartment().getName());

        EmployeeDetailDto dto = new EmployeeDetailDto();
        dto.setId(emp.getId());
        dto.setFirstName(emp.getFirstName());
        dto.setLastName(emp.getLastName());
        dto.setEmail(emp.getEmail());
        dto.setSalary(emp.getSalary());
        dto.setDepartment(deptDto);
        return dto;
    }
}