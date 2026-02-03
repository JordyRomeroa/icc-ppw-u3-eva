package ec.ecu.ups.icc.employees.ModuloCompany.Dto;

public class DepartmentSummaryDto {
    private Long id;
    private String name;
    private Double budget;
    private int employeeCount;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Double getBudget() { return budget; }
    public void setBudget(Double budget) { this.budget = budget; }
    public int getEmployeeCount() { return employeeCount; }
    public void setEmployeeCount(int employeeCount) { this.employeeCount = employeeCount; }
}