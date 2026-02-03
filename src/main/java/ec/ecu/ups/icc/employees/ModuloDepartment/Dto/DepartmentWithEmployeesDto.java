package ec.ecu.ups.icc.employees.ModuloDepartment.Dto;

import java.util.List;

public class DepartmentWithEmployeesDto {
    private Long id;
    private String name;
    private Double budget;
    
    
    private CompanySimpleDto company;
    private List<EmployeeSimpleDto> employees;
    private int employeeCount;
    private Double totalSalaries;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Double getBudget() { return budget; }
    public void setBudget(Double budget) { this.budget = budget; }
    
    public CompanySimpleDto getCompany() { return company; }
    public void setCompany(CompanySimpleDto company) { this.company = company; }
    
    public List<EmployeeSimpleDto> getEmployees() { return employees; }
    public void setEmployees(List<EmployeeSimpleDto> employees) { this.employees = employees; }
    
    public int getEmployeeCount() { return employeeCount; }
    public void setEmployeeCount(int employeeCount) { this.employeeCount = employeeCount; }
    public Double getTotalSalaries() { return totalSalaries; }
    public void setTotalSalaries(Double totalSalaries) { this.totalSalaries = totalSalaries; }
}