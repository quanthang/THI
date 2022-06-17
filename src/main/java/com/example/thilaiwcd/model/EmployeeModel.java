package com.example.thilaiwcd.model;
import com.example.thilaiwcd.entity.Employee;
import java.util.List;

public interface EmployeeModel {
    boolean save(Employee obj);
    List<Employee> findAll();
}
