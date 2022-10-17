package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class EmployeeBook {

    private final Map<String, Employee> employees = new HashMap<>();


    private String getKey(Employee employee) {
        return employee.getFirstName() + " " + employee.getLastName();
    }

    public void addEmployee(Employee employee) {
        employees.put(getKey(employee), employee);
    }

    public void addEmployee(String firstName, String lastName, double salary, int department) {
        addEmployee(new Employee(firstName, lastName, salary, department));
    }

    public void removeEmployee(Employee employee) {
        employees.remove(getKey(employee));
    }

    public void removeEmployee(int id) {
        String employeeKeyForRemoving = null;
        for (String key : employees.keySet()) {
            if (employees.get(key).getId == id) {
                employeeKeyForRemoving = key;
                break;
            }
        }
        if (employeeKeyForRemoving != null) {
            employees.remove(employeeKeyForRemoving);
        }
    }

    public void changeSalary(Employee employee, double newSalary) {
        String key = getKey(employee);
        if (employees.containsKey(key)) {
            employees.get(key).setSalary(newSalary);
        }
    }

    public void changeDepartment(Employee employee, int newDepartment) {
        String key = getKey(employee);
        if (employees.containsKey(key)) {
            employees.get(key).setDepartment(newDepartment);
        }
    }

    public void printEmployeeByDepartment() {
        for (int department = 1; department <= 5; department++) {
            System.out.println("Сотрудники из отдела " + department + ":");
        }
        for (Employee employee : employees.values()) {
            if (Objects.nonNull(employee) && employee.getDepartment() == depatrment) {
                System.out.println(employee.getFirstName() + " " + employee.getLastName());
            }
        }
    }

    public void printEmployeeWithSalaryLessThan(double bound) {
        
    }


}
