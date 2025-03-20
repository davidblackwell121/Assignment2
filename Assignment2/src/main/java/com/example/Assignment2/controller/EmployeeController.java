package com.example.Assignment2.controller; // Exists within the controller package

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

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final DepartmentService departmentService;
    private final SalaryService salaryService;

    @Autowired
    public EmployeeController(EmployeeService employeeService,
                              DepartmentService departmentService,
                              SalaryService salaryService) {
        this.employeeService = employeeService;
        this.departmentService = departmentService;
        this.salaryService = salaryService;
    }

    // Display the employee registration form
    @GetMapping("/register")
    public String showEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("departments", departmentService.getAllDepartments());
        return "employee-form";
    }

    // Handle form submission
    @PostMapping("/register")
    public String registerEmployee(@Valid @ModelAttribute("employee") Employee employee,
                                   BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("departments", departmentService.getAllDepartments());
            return "employee-form"; // Reload the form with errors
        }

        // Auto-calculate salary based on designation
        employee.setSalary(salaryService.calculateSalary(employee.getDesignation()));

        // Save employee
        employeeService.saveEmployee(employee);

        // Redirect to success page
        return "redirect:/employees/success";
    }

    // Success page after successful registration
    @GetMapping("/success")
    public String showSuccessPage() {
        return "success";
    }

    // Display all employees
    @GetMapping("/list")
    public String listEmployees(Model model) {
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        return "employee-list";
    }
}