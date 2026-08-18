package com.tka.employee.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tka.employee.dto.BonusResponse;
import com.tka.employee.dto.DepartmentSummaryResponse;
import com.tka.employee.dto.EmployeeAddResponse;
import com.tka.employee.dto.EmployeeResponse;
import com.tka.employee.entity.Employee;
import com.tka.employee.exception.EmployeeNotFoundException;
import com.tka.employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    // API 1
    @Override
    public EmployeeAddResponse addEmployee(Employee employee) {

        // Salary validation
        if (employee.getMonthlySalary() == null ||
            employee.getMonthlySalary() <= 15000) {

            throw new IllegalArgumentException(
                    "Monthly salary must be greater than 15000");
        }

        // Save using Hibernate
        Employee savedEmployee = repository.save(employee);

        return new EmployeeAddResponse(
                "Employee added successfully",
                savedEmployee.getEmployeeId(),
                savedEmployee.getEmployeeName()
        );
    }

    // API 2
    @Override
    public List<EmployeeResponse> getEmployeesByDepartment(
            String department) {

        List<Employee> employees =
                repository.findByDepartmentIgnoreCase(department);

        return employees.stream()
                .map(employee -> {

                    double annualSalary =
                            employee.getMonthlySalary() * 12;

                    return new EmployeeResponse(
                            employee.getEmployeeId(),
                            employee.getEmployeeName(),
                            employee.getDepartment(),
                            employee.getMonthlySalary(),
                            annualSalary,
                            employee.getPerformanceScore()
                    );
                })
                .toList();
    }

    // API 3
    @Override
    public BonusResponse calculateBonus(Integer employeeId) {

        Employee employee = repository.findById(employeeId)
                .orElseThrow(() ->
                        new EmployeeNotFoundException(
                                "Employee not found with ID: "
                                        + employeeId));

        double performanceScore =
                employee.getPerformanceScore();

        int bonusPercentage;

        if (performanceScore >= 9) {

            bonusPercentage = 20;

        } else if (performanceScore >= 8) {

            bonusPercentage = 15;

        } else if (performanceScore >= 7) {

            bonusPercentage = 10;

        } else {

            bonusPercentage = 0;
        }

        double bonusAmount =
                employee.getMonthlySalary()
                        * bonusPercentage / 100;

        double salaryAfterBonus =
                employee.getMonthlySalary()
                        + bonusAmount;

        return new BonusResponse(
                employee.getEmployeeId(),
                employee.getEmployeeName(),
                employee.getMonthlySalary(),
                employee.getPerformanceScore(),
                bonusPercentage,
                round(bonusAmount),
                round(salaryAfterBonus)
        );
    }

    // API 4
    @Override
    public DepartmentSummaryResponse getDepartmentSummary(
            String department) {

        List<Employee> employees =
                repository.findByDepartmentIgnoreCase(department);

        if (employees.isEmpty()) {

            throw new EmployeeNotFoundException(
                    "No employees found in department: "
                            + department);
        }

        int totalEmployees = employees.size();

        int activeEmployees = (int) employees.stream()
                .filter(employee ->
                        employee.getStatus() != null &&
                        employee.getStatus()
                                .equalsIgnoreCase("Active"))
                .count();

        double totalMonthlySalary = employees.stream()
                .mapToDouble(Employee::getMonthlySalary)
                .sum();

        double averageSalary =
                totalMonthlySalary / totalEmployees;

        double averagePerformanceScore = employees.stream()
                .mapToDouble(Employee::getPerformanceScore)
                .average()
                .orElse(0);

        Employee highestPaidEmployee = employees.stream()
                .max((e1, e2) ->
                        Double.compare(
                                e1.getMonthlySalary(),
                                e2.getMonthlySalary()))
                .orElseThrow();

        Employee bestPerformingEmployee = employees.stream()
                .max((e1, e2) ->
                        Double.compare(
                                e1.getPerformanceScore(),
                                e2.getPerformanceScore()))
                .orElseThrow();

        return new DepartmentSummaryResponse(
                department,
                totalEmployees,
                activeEmployees,
                round(totalMonthlySalary),
                round(averageSalary),
                round(averagePerformanceScore),
                highestPaidEmployee.getEmployeeName(),
                bestPerformingEmployee.getEmployeeName()
        );
    }

    private double round(double value) {

        return BigDecimal.valueOf(value)
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
    }
}