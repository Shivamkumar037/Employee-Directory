package com.Employee.Directory.Controller;

import com.Employee.Directory.Entity.Employee;
import com.Employee.Directory.Service.EmployeeService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("employee")
public class EmployeeController {

    private EmployeeService employeeService;
    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }
@GetMapping("/delete")
public  String delete(@RequestParam("id")  Integer id){
        employeeService.deleteEmployee(id);
        return
    "redirect:/employee/";
}
    @GetMapping("/{id}")
    public String findEmployee(@PathVariable("id") Integer id , Model model){
        Employee employee=employeeService.findById(id);
        model.addAttribute("employee",employee);
        return "employee_data";
    }
    @GetMapping("/form")
    public String EmployeeForm( Model model){

        model.addAttribute("employee",new Employee());
        return "form";
    }
    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("employee") Employee employee,  BindingResult bindingResult,Model model){
       if (bindingResult.hasErrors()) return "form";
employeeService.createEmployee(employee);
        return "redirect:/employee/";

    }
@GetMapping("/update")
public  String update(@RequestParam("id") Integer id,Model model){
        Employee employee=employeeService.findById(id);
        model.addAttribute("employee",employee);
        return "updateform";

}
    @PostMapping("/update")
    public String update(
            @Valid @ModelAttribute("employee")Employee employee,BindingResult bindingResult,Model model){
        if(bindingResult.hasErrors()) return "updateform";
       employeeService.updateEmployee(employee);

        return "redirect:/employee/";
    }
    @GetMapping("/")
    public String findEmployee( Model model){
        List<Employee> employees=employeeService.AllEmployee();
        model.addAttribute("employee",employees);
        return "employee_data";
    }
}
