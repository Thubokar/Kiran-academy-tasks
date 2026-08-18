package com.tka.employee.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeId;

    @NotBlank(message = "Employee name must not be empty")
    private String employeeName;

    @NotBlank(message = "Department must not be empty")
    private String department;

    @Positive(message = "Monthly salary must be greater than 0")
    private Double monthlySalary;

    @Min(value = 0, message = "Experience years cannot be negative")
    private Integer experienceYears;

    @DecimalMin(value = "0.0", message = "Performance score must be between 0 and 10")
    @DecimalMax(value = "10.0", message = "Performance score must be between 0 and 10")
    private Double performanceScore;

    private String status;

    public Employee() {
    }

    public Employee(Integer employeeId, String employeeName, String department,
                    Double monthlySalary, Integer experienceYears,
                    Double performanceScore, String status) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.department = department;
        this.monthlySalary = monthlySalary;
        this.experienceYears = experienceYears;
        this.performanceScore = performanceScore;
        this.status = status;
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

    public Integer getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(Integer experienceYears) {
        this.experienceYears = experienceYears;
    }

    public Double getPerformanceScore() {
        return performanceScore;
    }

    public void setPerformanceScore(Double performanceScore) {
        this.performanceScore = performanceScore;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}