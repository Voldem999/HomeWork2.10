package org.example;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {

    private static final int SIZE = 10;
    private final Map<String, Employee> employees;

    public EmployeeService() {
        this.employees = new HashMap<>();
    }


    public Employee add(String firstName, String lastName, double salary, int departmentId) {
        Employee employee = new Employee(firstName, lastName, salary, departmentId);
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }
        if (employees.size() >= SIZE) {
            throw new EmployeeStorageIsFullException();
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }

    public Employee remove(String firstName, String lastName, double salary, int departmentId) {
        Employee employee = new Employee(firstName, lastName, salary, departmentId);
        if (employees.containsKey(employee.getFullName())) {
            employees.remove(employee.getFullName());
            return employee;
        }
        throw new EmployeeNotFoundException();
    }


    public Employee find(String firstName, String lastName, double salary, int departmentId) {
        Employee employee = new Employee(firstName, lastName, salary, departmentId);
        if (employees.containsKey(employee.getFullName())) {
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    public List<Employee> findAll() {
        return new ArrayList<>(employees.values());
    }

    public Collection<Object> getAll() {
        return null;
    }
}
