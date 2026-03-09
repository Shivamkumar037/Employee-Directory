package com.Employee.Directory.Service;

import com.Employee.Directory.Entity.Employee;
import com.Employee.Directory.Exception.EmployeeException;
import com.Employee.Directory.Reposetory.EmployeeRepo;
import com.Employee.Directory.Service.type.EmployeeDAO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements EmployeeDAO {
    private ModelMapper modelMapper = new ModelMapper();

    private EmployeeRepo employeeRepo;
    @Autowired
    private EmployeeService(EmployeeRepo employeeRepo){
        this.employeeRepo=employeeRepo;

    }


    @Override
    public Employee findById(Integer id) {
       return employeeRepo.findById(id).orElseThrow(()->new EmployeeException("Employee Not Found"));
    }

    @Override
    public Employee deleteEmployee(Integer id) {
Employee employee =findById(id);
employeeRepo.delete(employee);
        return employee;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        if (employee.getId()==null) throw new EmployeeException("something wrong");
        Employee employee1=findById(employee
                .getId());
      modelMapper.map(employee,employee1);

        return employeeRepo.save(employee1);
    }

    @Override
    public Employee createEmployee(Employee employee) {
        Employee employee1=employeeRepo.findByEmail(employee.getEmail()).orElse(null);
        if(employee1 !=null){
            throw new  EmployeeException("Employee Alrady Exist");
        }else {
            employeeRepo.save(employee);
        }
        return employee;
    }

    @Override
    public List<Employee> AllEmployee() {
        return employeeRepo.findAll();
    }
}
