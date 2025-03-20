package com.example.Assignment2.repository; // Exists within the repository package

// Imports for Classes and annotations,
// also imports JpaRepository for database operations
import com.example.Assignment2.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Marks the interface as a repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // JpaRepository already provides default CRUD methods used within the services
}
