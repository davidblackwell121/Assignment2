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
        salaryMap.put("Marketing Specialist", 70000.0);
        salaryMap.put("Software Engineer", 90000.0);
        salaryMap.put("UI/UX Designer", 110000.0);
        salaryMap.put("Technical Support Engineer", 130000.0);
        salaryMap.put("Data Scientist", 130000.0);
    }

    // Returns the appropriate salary based on designation
    public double calculateSalary(String designation) {
        return salaryMap.get(designation);
    }
}