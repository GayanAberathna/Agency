package com.example.ems.service;

import com.example.ems.model.Employee;
import com.example.ems.request.RegisterEmployee;
import com.example.ems.request.UpdateEmployee;
import com.example.ems.response.Response;

import java.util.List;

public interface EmployeeService {

    Response registerEmployee(RegisterEmployee registerEmployee);
    Response updateEmployee(UpdateEmployee updateEmployee);
    List<Employee> findAll();
    Employee fetch(int id);
    Response delete (int id);

}
