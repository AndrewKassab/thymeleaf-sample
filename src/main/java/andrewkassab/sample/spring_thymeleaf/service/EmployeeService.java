package andrewkassab.sample.spring_thymeleaf.service;

import andrewkassab.sample.spring_thymeleaf.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    void save(Employee employee);
    Employee getById(Long id);
    void deleteById(Long id);
}
