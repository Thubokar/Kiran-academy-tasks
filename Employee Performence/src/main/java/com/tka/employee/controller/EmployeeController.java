package com.tka.employee.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tka.employee.dto.BonusResponse;
import com.tka.employee.dto.DepartmentSummaryResponse;
import com.tka.employee.dto.EmployeeAddResponse;
import com.tka.employee.dto.EmployeeResponse;
import com.tka.employee.entity.Employee;
import com.tka.employee.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/employees")
@Validated
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<EmployeeAddResponse> addEmployee(
            @Valid @RequestBody Employee employee) {

        EmployeeAddResponse response =
                service.addEmployee(employee);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping("/department/{department}")
    public ResponseEntity<List<EmployeeResponse>>
    getEmployeesByDepartment(
            @PathVariable String department) {

        return ResponseEntity.ok(
                service.getEmployeesByDepartment(department));
    }

    @GetMapping("/{employeeId}/bonus")
    public ResponseEntity<BonusResponse> calculateBonus(
            @PathVariable Integer employeeId) {

        return ResponseEntity.ok(
                service.calculateBonus(employeeId));
    }

    @GetMapping("/summary/{department}")
    public ResponseEntity<DepartmentSummaryResponse>
    getDepartmentSummary(
            @PathVariable String department) {

        return ResponseEntity.ok(
                service.getDepartmentSummary(department));
    }
}