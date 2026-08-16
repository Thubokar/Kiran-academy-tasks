package com.Employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Employee.entity.Employee;
import com.Employee.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Add Employee
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Get Employee By ID
    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    // Update Employee
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Delete Employee
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }

    // Get All Employees
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Get Employees By Role
    public List<Employee> getEmployeesByRole(String roleName) {
        return employeeRepository.findByRole(roleName);
    }

    // Get Employees By Salary More Than
    public List<Employee> getEmployeesBySalaryMoreThan(double salAmt) {
        return employeeRepository.findBySalaryGreaterThan(salAmt);
    }
}