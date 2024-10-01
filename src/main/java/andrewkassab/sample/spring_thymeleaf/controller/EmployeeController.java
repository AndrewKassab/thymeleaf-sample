package andrewkassab.sample.spring_thymeleaf.controller;

import andrewkassab.sample.spring_thymeleaf.model.Employee;
import andrewkassab.sample.spring_thymeleaf.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("allemplist", employeeService.getAllEmployees());
        return "index";
    }

    @GetMapping("/addnew")
    public String addNewEmployee(Model model) {
        model.addAttribute("employee", new Employee());
        return "newemployee";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute Employee employee) {
        employeeService.save(employee);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String updateForm(@PathVariable Long id, Model model) {
        var employee = employeeService.getById(id);
        model.addAttribute("employee", employee);
        return "update";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteById(@PathVariable Long id) {
        employeeService.deleteById(id);
        return "redirect:/";
    }

}
