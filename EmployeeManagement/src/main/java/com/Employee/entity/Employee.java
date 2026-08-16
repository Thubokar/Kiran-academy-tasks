package com.Employee.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee {

    @Id
    private int eid;

    private String name;
    private String role;
    private LocalDate doj;
    private double salary;

    public Employee() {
    }

    public Employee(int eid, String name, String role, LocalDate doj, double salary) {
        this.eid = eid;
        this.name = name;
        this.role = role;
        this.doj = doj;
        this.salary = salary;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDate getDoj() {
        return doj;
    }

    public void setDoj(LocalDate doj) {
        this.doj = doj;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee [eid=" + eid + ", name=" + name + ", role=" + role
                + ", doj=" + doj + ", salary=" + salary + "]";
    }
}