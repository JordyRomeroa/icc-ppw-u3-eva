package ec.ecu.ups.icc.employees.ModuloCompany.Dto;

import java.util.List;

public class CompanyDepartmentsDto {
    private Long companyId;
    private String companyName;
    private String country;
    private int departmentCount;
    private List<DepartmentSummaryDto> departments;
    private Double totalBudget;

    public Long getCompanyId() { return companyId; }
    public void setCompanyId(Long companyId) { this.companyId = companyId; }
    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }
    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }
    public int getDepartmentCount() { return departmentCount; }
    public void setDepartmentCount(int departmentCount) { this.departmentCount = departmentCount; }
    public List<DepartmentSummaryDto> getDepartments() { return departments; }
    public void setDepartments(List<DepartmentSummaryDto> departments) { this.departments = departments; }
    public Double getTotalBudget() { return totalBudget; }
    public void setTotalBudget(Double totalBudget) { this.totalBudget = totalBudget; }
}