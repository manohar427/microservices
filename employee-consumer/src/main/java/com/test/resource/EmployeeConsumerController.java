package com.test.resource;

import com.test.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class EmployeeConsumerController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("getEmployee")
    public Employee getEmployee() {
        Employee employee = restTemplate.getForObject("http://employee-zuul/xxx/employee", Employee.class);
        return employee;
    }
}
