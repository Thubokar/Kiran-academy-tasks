package com.tka.employee.dto;

public class BonusResponse {

    private Integer employeeId;
    private String employeeName;
    private Double monthlySalary;
    private Double performanceScore;
    private Integer bonusPercentage;
    private Double bonusAmount;
    private Double salaryAfterBonus;

    public BonusResponse() {
    }

    public BonusResponse(Integer employeeId, String employeeName,
                         Double monthlySalary, Double performanceScore,
                         Integer bonusPercentage, Double bonusAmount,
                         Double salaryAfterBonus) {

        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.monthlySalary = monthlySalary;
        this.performanceScore = performanceScore;
        this.bonusPercentage = bonusPercentage;
        this.bonusAmount = bonusAmount;
        this.salaryAfterBonus = salaryAfterBonus;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public Double getMonthlySalary() {
        return monthlySalary;
    }

    public Double getPerformanceScore() {
        return performanceScore;
    }

    public Integer getBonusPercentage() {
        return bonusPercentage;
    }

    public Double getBonusAmount() {
        return bonusAmount;
    }

    public Double getSalaryAfterBonus() {
        return salaryAfterBonus;
    }
}