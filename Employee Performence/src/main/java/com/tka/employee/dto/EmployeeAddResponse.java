package com.tka.employee.dto;

public class EmployeeAddResponse {

    private String message;
    private Integer employeeId;
    private String employeeName;

    public EmployeeAddResponse() {
    }

    public EmployeeAddResponse(String message, Integer employeeId,
                               String employeeName) {
        this.message = message;
        this.employeeId = employeeId;
        this.employeeName = employeeName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
}