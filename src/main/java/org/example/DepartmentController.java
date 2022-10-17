package org.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    public Employee findEmployeeWithMaxSalaryFromDepartment (@RequestParam("departmentId") int department) {
        return departmentService.findEmployeeWithMaxSalaryFromDepartment(deapartmet);
    }

    @GetMapping("/min-salary")
    public Employee findEmployeeWithMinSalaryFromDepartment (@RequestParam("departmentId") int department) {
        return departmentService.findEmployeeWithMinSalaryFromDepartment(deapartmet);
    }

    @GetMapping("/all")
    public Collection<Employee> findEmployeesFromDepartment (@RequestParam("departmentId") int department) {
        return departmentService.findEmployeesFromDepartment(deapartmet);
    }

    @GetMapping("/all")
    public Map <Integer, List<Employee>> findEmployees () {
        return departmentService.findEmployees();
    }
}
