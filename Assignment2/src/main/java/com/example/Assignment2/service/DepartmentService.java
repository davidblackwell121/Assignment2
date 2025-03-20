package com.example.Assignment2.service; // Exists within the service package

// Class, interface, and annotation imports
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

@Service // Marks this class a Spring service component
public class DepartmentService {
    // Returns a list of predefined department names
    public List<String> getAllDepartments() {
        // Returns the array of departments as a list
        return Arrays.asList("HR", "Finance", "Engineering", "Marketing", "Sales");
    }
}
