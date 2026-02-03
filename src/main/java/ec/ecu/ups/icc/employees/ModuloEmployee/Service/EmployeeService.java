package ec.ecu.ups.icc.employees.ModuloEmployee.Service;

import ec.ecu.ups.icc.employees.ModuloDepartment.Entity.Department;
import ec.ecu.ups.icc.employees.ModuloDepartment.Repository.DepartmentRepository;
import ec.ecu.ups.icc.employees.ModuloEmployee.Dto.TransferRequestDto;
import ec.ecu.ups.icc.employees.ModuloEmployee.Dto.EmployeeTransferResponseDto;
import ec.ecu.ups.icc.employees.ModuloEmployee.Dto.DepartmentInfo;
import ec.ecu.ups.icc.employees.ModuloEmployee.Entity.Employee;
import ec.ecu.ups.icc.employees.ModuloEmployee.Repository.EmployeeRepository;
import ec.ecu.ups.icc.employees.exception.ConflictException;
import ec.ecu.ups.icc.employees.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    public EmployeeService(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    @Transactional
    public EmployeeTransferResponseDto transferEmployee(Long employeeId, TransferRequestDto request) {
        Employee employee = employeeRepository.findByIdAndActive(employeeId, 'S')
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found or inactive"));

        Department newDept = departmentRepository.findByIdAndActive(request.getNewDepartmentId(), 'S')
                .orElseThrow(() -> new ResourceNotFoundException("Target department not found or inactive"));

        Department oldDept = employee.getDepartment();

        if (oldDept.getId().equals(newDept.getId())) {
            throw new ConflictException("Employee is already in the target department");
        }

        DepartmentInfo oldDeptDto = new DepartmentInfo();
        oldDeptDto.setId(oldDept.getId());
        oldDeptDto.setName(oldDept.getName());

        employee.setDepartment(newDept);
        employeeRepository.save(employee);

        DepartmentInfo newDeptDto = new DepartmentInfo();
        newDeptDto.setId(newDept.getId());
        newDeptDto.setName(newDept.getName());

        EmployeeTransferResponseDto response = new EmployeeTransferResponseDto();
        response.setEmployeeId(employee.getId());
        response.setEmployeeName(employee.getFirstName() + " " + employee.getLastName());
        response.setOldDepartment(oldDeptDto);
        response.setNewDepartment(newDeptDto);
        response.setMessage("Employee transferred successfully");

        return response;
    }
}