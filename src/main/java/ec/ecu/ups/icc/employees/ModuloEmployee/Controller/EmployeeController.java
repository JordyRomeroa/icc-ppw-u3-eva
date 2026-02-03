package ec.ecu.ups.icc.employees.ModuloEmployee.Controller;

import ec.ecu.ups.icc.employees.ModuloEmployee.Dto.TransferRequestDto;
import ec.ecu.ups.icc.employees.ModuloEmployee.Dto.EmployeeTransferResponseDto;
import ec.ecu.ups.icc.employees.ModuloEmployee.Service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PatchMapping("/{employeeId}/transfer")
    public ResponseEntity<EmployeeTransferResponseDto> transferEmployee(
            @PathVariable Long employeeId,
            @RequestBody TransferRequestDto request) {
        return ResponseEntity.ok(employeeService.transferEmployee(employeeId, request));
    }
}