package com.Employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Employee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findByRole(String role);
    List<Employee> findBySalaryGreaterThan(double salary);
}