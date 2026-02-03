package ec.ecu.ups.icc.employees.ModuloCompany.Controller;

import ec.ecu.ups.icc.employees.ModuloCompany.Dto.CompanyDepartmentsDto;
import ec.ecu.ups.icc.employees.ModuloCompany.Dto.EmployeesResponseDto;
import ec.ecu.ups.icc.employees.ModuloCompany.Service.CompanyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/{id}/departments")
    public ResponseEntity<CompanyDepartmentsDto> getDepartments(@PathVariable Long id) {
        return ResponseEntity.ok(companyService.getCompanyDepartments(id));
    }

    @GetMapping("/{id}/high-salary-employees")
    public ResponseEntity<EmployeesResponseDto> getHighSalaryEmployees(
            @PathVariable Long id,
            @RequestParam(required = false) Double minSalary) {
        return ResponseEntity.ok(companyService.getHighSalaryEmployees(id, minSalary));
    }
}