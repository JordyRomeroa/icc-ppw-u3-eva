
package ec.ecu.ups.icc.employees.ModuloCompany.Dto;

import java.util.List;

public class DepartmentDtos {

    public static class DepartmentWithEmployeesDto {
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

    public static class CompanySimpleDto {
        private Long id;
        private String name;
        private String country;

        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public String getCountry() { return country; }
        public void setCountry(String country) { this.country = country; }
    }

    public static class EmployeeSimpleDto {
        private Long id;
        private String firstName;
        private String lastName;
        private String email;
        private Double salary;

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
    }
}