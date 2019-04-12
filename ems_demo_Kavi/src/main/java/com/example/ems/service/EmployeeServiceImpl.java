package com.example.ems.service;

import com.example.ems.enums.MessageTags;
import com.example.ems.model.Employee;
import com.example.ems.repository.EmployeeRepository;
import com.example.ems.request.RegisterEmployee;
import com.example.ems.request.UpdateEmployee;
import com.example.ems.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;


    @Override
    public Response registerEmployee(RegisterEmployee registerEmployee) {
        Employee employee = new Employee();
        employee.setFirstName(registerEmployee.getFirstName());
        employee.setLastName(registerEmployee.getLastName());
        employee.setAddress(registerEmployee.getAddress());
        employee.setBirthDay(registerEmployee.getBirthDay());


        employeeRepository.save(employee);

        return new Response(true, MessageTags.REGISTER_SUCCESS.name(),MessageTags.REGISTER_SUCCESS.getString());


    }

    @Override
    public Response updateEmployee(UpdateEmployee updateEmployee) {
        Employee employee = employeeRepository.findById(updateEmployee.getId());
        employee.setFirstName(updateEmployee.getFirstName());
        employee.setLastName(updateEmployee.getLastName());
        employee.setBirthDay(updateEmployee.getBirthDay());
        employee.setAddress(updateEmployee.getAddress());

        employeeRepository.save(employee);

        return new Response(true, MessageTags.UPDATE_SUCCESS.name(),MessageTags.UPDATE_SUCCESS.getString());


    }

    @Override
    public List<Employee> findAll() {
        List<Employee> employees = employeeRepository.findAll();
        return employees;
    }

    @Override
    public Employee fetch(int id) {
        Employee employee = employeeRepository.findById(id);
        return employee;
    }

    @Override
    public Response delete(int id) {
        Employee employee = employeeRepository.findById(id);
        employeeRepository.delete(employee);
        return new Response(true,MessageTags.DELETE_SUCCESS.name(),MessageTags.DELETE_SUCCESS.getString());

    }
}
