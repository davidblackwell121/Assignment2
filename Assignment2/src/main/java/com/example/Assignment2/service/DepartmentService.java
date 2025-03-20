package com.example.Assignment2.service;

import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

@Service
public class DepartmentService {

    public List<String> getAllDepartments() {
        return Arrays.asList("HR", "Finance", "Engineering", "Marketing", "Sales");
    }
}

