package com.Employee.Directory.ExceptionHandler;

import com.Employee.Directory.Exception.EmployeeException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {
    @ExceptionHandler(EmployeeException.class)
    public String employeeNotFoundException(Model model,EmployeeException employeeException){
        model.addAttribute("not_found",employeeException);
        return "error";

    }
}
