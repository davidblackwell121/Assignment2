package com.example.Assignment2.service; // Exists within the service package

import org.springframework.stereotype.Service; // Imports @Service annotation
import java.util.HashMap; // Imports HashMap class to store key-value pairs
import java.util.Map; // Map interface implemented by HashMap

@Service // Marks this class as a Spring service component
public class SalaryService {
    // Stores salary by designation into a map interface
    private final Map<String, Double> salaryMap = new HashMap<>();

    public SalaryService() {
        // Define salary based on employee designation
        salaryMap.put("Software Engineer", 70000.0);
        salaryMap.put("Senior Engineer", 90000.0);
        salaryMap.put("Manager", 110000.0);
        salaryMap.put("Director", 130000.0);
    }

    // Returns the appropriate salary or
    // Creates a default salary if designation isn't found
    public double calculateSalary(String designation) {
        return salaryMap.getOrDefault(designation, 50000.0);
    }
}
