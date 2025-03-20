package com.example.Assignment2.model; // Exists within the model package

import jakarta.persistence.*; // Imports JPA annotations for ORM
import jakarta.validation.constraints.NotEmpty; // Import NotEmpty validation annotation
import lombok.*; // Imports Lombok annotations to reduce boilerplate code

import java.util.Set;

@Entity // Marks Employee class as a JPA entity in the database
@Table(name = "employees") // Specifies the table name in the database
@Getter // Lombok automatically generates getter methods
@Setter // Lombok automatically generates getter methods
@NoArgsConstructor // Lombok annotation to generate a no-argument constructor
@AllArgsConstructor // Lombok annotation to generate a constructor with all fields
@ToString

public class Employee {
    @Id // Marks the id as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto generates the ID for each employee
    private int id;

    @NotEmpty(message = "Name is required") // Ensures the field is populated
    private String name;

    @NotEmpty(message = "Designation is required") // // Ensures the field is populated
    private String designation;

    public double salary; // Will be auto calculated based on designation

    private boolean employmentType; // true = full-time and false = part-time

    @ElementCollection // Specifies that the departments are stored as a collection
    @CollectionTable(name = "employee_departments", joinColumns = @JoinColumn(name = "employee_id")) // // Defines the table and column for departments
    @Column(name = "department") // Specifies the column name for departments
    private Set<String> departments; // Set of departments the employee is in
}
