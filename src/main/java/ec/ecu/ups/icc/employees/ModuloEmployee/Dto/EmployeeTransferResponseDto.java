package ec.ecu.ups.icc.employees.ModuloEmployee.Dto;

public class EmployeeTransferResponseDto {
    private Long employeeId;
    private String employeeName;
    private DepartmentInfo oldDepartment;
    private DepartmentInfo newDepartment;
    private String message;

    public Long getEmployeeId() { return employeeId; }
    public void setEmployeeId(Long employeeId) { this.employeeId = employeeId; }
    public String getEmployeeName() { return employeeName; }
    public void setEmployeeName(String employeeName) { this.employeeName = employeeName; }
    public DepartmentInfo getOldDepartment() { return oldDepartment; }
    public void setOldDepartment(DepartmentInfo oldDepartment) { this.oldDepartment = oldDepartment; }
    public DepartmentInfo getNewDepartment() { return newDepartment; }
    public void setNewDepartment(DepartmentInfo newDepartment) { this.newDepartment = newDepartment; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}