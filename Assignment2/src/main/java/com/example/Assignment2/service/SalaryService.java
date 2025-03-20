package com.example.Assignment2.service;

import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class SalaryService {
    private final Map<String, Double> SalaryMap = new HashMap<>();

    public SalaryService() {
        // Define salary based on designation
        salaryMap.put("Software Engineer", 70000.0);
        salaryMap.put("Senior Engineer", 90000.0);
        salaryMap.put("Manager", 110000.0);
        salaryMap.put("Director", 130000.0);
    }

    // Creates a default salary if designation isn't found
    public double calculateSalary(String designation) {
        return salaryMap.getOrDefault(designation, 50000.0);
    }
}
