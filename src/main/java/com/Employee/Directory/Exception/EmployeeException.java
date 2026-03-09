package com.Employee.Directory.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EmployeeException extends RuntimeException {
    public EmployeeException(String message){
        super(message);
    }

}
