package com.example.Assignment2.service; // Exists within the service package

// Imports for various classes, interfaces, and annotations
import com.example.Assignment2.model.Employee;
import com.example.Assignment2.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Marks class as a Spring service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired // Spring injects EmployeeRepository into this service
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository; // Initializes with constructor
    }

    // Gets all the employees from the database
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll(); // Uses findAll method to retrieve all the employees
    }

    // Save a new employee to the database
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
}
