package ec.ecu.ups.icc.employees.ModuloDepartment.Controller;

import ec.ecu.ups.icc.employees.ModuloDepartment.Dto.DepartmentWithEmployeesDto;
import ec.ecu.ups.icc.employees.ModuloDepartment.Service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/{id}/employees")
    public ResponseEntity<DepartmentWithEmployeesDto> getDepartmentWithEmployees(
            @PathVariable Long id,
            @RequestParam(required = false, defaultValue = "desc") String sort) {
        return ResponseEntity.ok(departmentService.getDepartmentWithEmployees(id, sort));
    }
}