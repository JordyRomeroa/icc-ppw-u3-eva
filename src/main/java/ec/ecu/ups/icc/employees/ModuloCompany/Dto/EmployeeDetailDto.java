package ec.ecu.ups.icc.employees.ModuloCompany.Dto;

public class EmployeeDetailDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Double salary;
    private DepartmentSimpleDto department;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public Double getSalary() { return salary; }
    public void setSalary(Double salary) { this.salary = salary; }
    public DepartmentSimpleDto getDepartment() { return department; }
    public void setDepartment(DepartmentSimpleDto department) { this.department = department; }
}