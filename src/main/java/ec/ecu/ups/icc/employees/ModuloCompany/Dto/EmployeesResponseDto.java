package ec.ecu.ups.icc.employees.ModuloCompany.Dto;

import java.util.List;

public class EmployeesResponseDto {
    private String companyName;
    private Double minSalary;
    private int count;
    private List<EmployeeDetailDto> employees;

    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }
    public Double getMinSalary() { return minSalary; }
    public void setMinSalary(Double minSalary) { this.minSalary = minSalary; }
    public int getCount() { return count; }
    public void setCount(int count) { this.count = count; }
    public List<EmployeeDetailDto> getEmployees() { return employees; }
    public void setEmployees(List<EmployeeDetailDto> employees) { this.employees = employees; }
}