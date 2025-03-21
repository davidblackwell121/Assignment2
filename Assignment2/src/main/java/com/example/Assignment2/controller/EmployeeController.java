package com.example.Assignment2.controller; // Exists within the controller package

// Imports for classes, interfaces, and controllers
import com.example.Assignment2.model.Employee;
import com.example.Assignment2.service.EmployeeService;
import com.example.Assignment2.service.DepartmentService;
import com.example.Assignment2.service.SalaryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller // Marks this class as a Spring MVC controller
@RequestMapping("/employees") // Specifies the URL for employee endpoints
public class EmployeeController {
    // Declares services from the service package
    private final EmployeeService employeeService;
    private final DepartmentService departmentService;
    private final SalaryService salaryService;

    @Autowired // Injects dependencies into the controller
    public EmployeeController(EmployeeService employeeService,
                              DepartmentService departmentService,
                              SalaryService salaryService) {
        this.employeeService = employeeService; // Assigns the injected instance to be used throughout controller
        this.departmentService = departmentService; // Assigns the injected instance to be used throughout controller
        this.salaryService = salaryService; // Assigns the injected instance to be used throughout controller
    }

    // Display the employee registration form
    @GetMapping("/register")
    public String showEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee()); // Adds an empty employee object
        model.addAttribute("departments", departmentService.getAllDepartments());
        return "employee-form"; // Returns the form view
    }

    // Handles the form submission
    @PostMapping("/register")
    public String registerEmployee(@Valid @ModelAttribute("employee") Employee employee,
                                   BindingResult result, Model model) {
        if (result.hasErrors()) // If there are validation errors
        {
            // Get all the departments again
            model.addAttribute("departments", departmentService.getAllDepartments());
            return "employee-form"; // Return to the registration form with errors
        }

        // Auto-calculate salary based on designation
        employee.setSalary(salaryService.calculateSalary(employee.getDesignation()));

        // Save employee to the database
        employeeService.saveEmployee(employee);

        // Redirect to success page if registration was successful
        return "redirect:/employees/success";
    }

    // Display the success page after successful registration
    @GetMapping("/success")
    public String showSuccessPage() {
        return "success"; // Returns the success view
    }

    // Display all employees
    @GetMapping("/list")
    public String listEmployees(Model model) {
        // Grabs the list of employees from the database
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees); // Add the list to the model
        return "employee-list"; // Return the employee list view
    }
}