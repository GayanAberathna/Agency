package com.example.ems.controller;

import com.example.ems.model.Employee;
import com.example.ems.request.RegisterEmployee;
import com.example.ems.request.UpdateEmployee;
import com.example.ems.response.Response;
import com.example.ems.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(method = RequestMethod.POST, path = "/employee")
public class EmployeeControllerImpl implements EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Override
    public Response registerEmployee(@RequestBody RegisterEmployee registerEmployee) {
        Response registerResponse = employeeService.registerEmployee(registerEmployee);
        return registerResponse;
    }

    @Override
    public Response updateEmployee(@RequestBody UpdateEmployee updateEmployee) {
        Response updateResponse = employeeService.updateEmployee(updateEmployee);
        return updateResponse;
    }

    @Override
        public List<Employee> findAll(){
        List<Employee> employees =  employeeService.findAll();
        return employees;

    }

    @Override
    public Employee fetch(@RequestParam int id){
        Employee employee =  employeeService.fetch( id);
        return employee;

    }

    @Override
    public Response delete(@RequestParam int id){
        Response response =  employeeService.delete(id);
        return  response;

    }



}
