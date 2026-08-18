package com.tka.employee.dto;

public class EmployeeResponse {

    private Integer employeeId;
    private String employeeName;
    private String department;
    private Double monthlySalary;
    private Double annualSalary;
    private Double performanceScore;

    public EmployeeResponse() {
    }

    public EmployeeResponse(Integer employeeId, String employeeName,
                            String department, Double monthlySalary,
                            Double annualSalary, Double performanceScore) {

        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.department = department;
        this.monthlySalary = monthlySalary;
        this.annualSalary = annualSalary;
        this.performanceScore = performanceScore;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(Double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public Double getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(Double annualSalary) {
        this.annualSalary = annualSalary;
    }

    public Double getPerformanceScore() {
        return performanceScore;
    }

    public void setPerformanceScore(Double performanceScore) {
        this.performanceScore = performanceScore;
    }
}