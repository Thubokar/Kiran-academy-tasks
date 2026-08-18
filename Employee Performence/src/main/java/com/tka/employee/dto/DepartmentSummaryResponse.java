package com.tka.employee.dto;

public class DepartmentSummaryResponse {

    private String department;
    private Integer totalEmployees;
    private Integer activeEmployees;
    private Double totalMonthlySalary;
    private Double averageSalary;
    private Double averagePerformanceScore;
    private String highestPaidEmployee;
    private String bestPerformingEmployee;

    public DepartmentSummaryResponse() {
    }

    public DepartmentSummaryResponse(String department,
                                     Integer totalEmployees,
                                     Integer activeEmployees,
                                     Double totalMonthlySalary,
                                     Double averageSalary,
                                     Double averagePerformanceScore,
                                     String highestPaidEmployee,
                                     String bestPerformingEmployee) {

        this.department = department;
        this.totalEmployees = totalEmployees;
        this.activeEmployees = activeEmployees;
        this.totalMonthlySalary = totalMonthlySalary;
        this.averageSalary = averageSalary;
        this.averagePerformanceScore = averagePerformanceScore;
        this.highestPaidEmployee = highestPaidEmployee;
        this.bestPerformingEmployee = bestPerformingEmployee;
    }

    public String getDepartment() {
        return department;
    }

    public Integer getTotalEmployees() {
        return totalEmployees;
    }

    public Integer getActiveEmployees() {
        return activeEmployees;
    }

    public Double getTotalMonthlySalary() {
        return totalMonthlySalary;
    }

    public Double getAverageSalary() {
        return averageSalary;
    }

    public Double getAveragePerformanceScore() {
        return averagePerformanceScore;
    }

    public String getHighestPaidEmployee() {
        return highestPaidEmployee;
    }

    public String getBestPerformingEmployee() {
        return bestPerformingEmployee;
    }
}