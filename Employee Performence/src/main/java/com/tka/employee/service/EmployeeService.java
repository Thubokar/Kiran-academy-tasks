package com.tka.employee.service;

import java.util.List;

import com.tka.employee.dto.BonusResponse;
import com.tka.employee.dto.DepartmentSummaryResponse;
import com.tka.employee.dto.EmployeeAddResponse;
import com.tka.employee.dto.EmployeeResponse;
import com.tka.employee.entity.Employee;

public interface EmployeeService {

    EmployeeAddResponse addEmployee(Employee employee);

    List<EmployeeResponse> getEmployeesByDepartment(String department);

    BonusResponse calculateBonus(Integer employeeId);

    DepartmentSummaryResponse getDepartmentSummary(String department);
}