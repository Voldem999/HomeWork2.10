package org.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee add(@RequestParam String firstName,
                        @RequestParam String lastName,
                        @RequestParam double salary,
                        @RequestParam int department) {
        return employeeService.add(firstName, lastName, salary, department);
    }

    @GetMapping("/remove")
    public Employee remove(@RequestParam String firstName,
                           @RequestParam String lastName,
                           @RequestParam double salary,
                           @RequestParam int department) {
        return employeeService.remove(firstName, lastName, salary, department);
    }

    @GetMapping("/find")
    public Employee find(@RequestParam String firstName,
                         @RequestParam String lastName,
                         @RequestParam double salary,
                         @RequestParam int department) {
        return employeeService.find(firstName, lastName, salary, department);
    }

    @GetMapping
    public List<Employee> findAll() {
        return employeeService.findAll();
    }
}
