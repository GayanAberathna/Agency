package com.example.ems.controller;

import com.example.ems.model.Employee;
import com.example.ems.request.RegisterEmployee;
import com.example.ems.request.UpdateEmployee;
import com.example.ems.response.Response;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface EmployeeController {
    @PostMapping(path = "/register")
    Response registerEmployee(@RequestBody RegisterEmployee registerEmployee);

    @PostMapping(path = "/update")
    Response updateEmployee(@RequestBody UpdateEmployee updateEmployee);

    @GetMapping(path="/home")
    List<Employee> findAll();

    @GetMapping(path="/getbyid")
    Employee fetch(@RequestParam int id);

    @DeleteMapping(path="/delete")
    Response delete(@RequestParam int id);
}
