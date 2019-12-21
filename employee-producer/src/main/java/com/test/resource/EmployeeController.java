package com.test.resource;

import com.test.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @GetMapping("/employee")
    public Employee getEmployee() {
        System.out.println("Employee producer services called.............");
        return new Employee("Emp1", "Desc", 10000, 4526);
    }
}
