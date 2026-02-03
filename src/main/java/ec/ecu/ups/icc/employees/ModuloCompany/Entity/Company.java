package ec.ecu.ups.icc.employees.ModuloCompany.Entity;

import jakarta.persistence.*;
import java.util.List;

import ec.ecu.ups.icc.employees.ModuloDepartment.Entity.Department;

@Entity
@Table(name = "companies")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String country;
    private Character active;

    @OneToMany(mappedBy = "company")
    private List<Department> departments;

    public Company() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }
    public Character getActive() { return active; }
    public void setActive(Character active) { this.active = active; }
    public List<Department> getDepartments() { return departments; }
    public void setDepartments(List<Department> departments) { this.departments = departments; }
}
