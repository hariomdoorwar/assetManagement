package com.assetManagement.assetManagement.controller;

import com.assetManagement.assetManagement.Exception.ResourceNotFound;
import com.assetManagement.assetManagement.entity.Employee;
import com.assetManagement.assetManagement.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RestController
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;
    @GetMapping("/home")
    public String home(){
        return "hariom";
    }

    @GetMapping("/employee")
    public List<Employee> getAll(){

        return employeeRepository.findAll();
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long Eid)
            throws ResourceNotFound {
        Employee employee = employeeRepository.findById(Eid)
                .orElseThrow(() -> new ResourceNotFound("Employee not found for this id :: " + Eid));
        return ResponseEntity.ok().body(employee);
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId,
                                                   @RequestBody Employee employeeDetails) throws ResourceNotFound{
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFound("Employee not found for this id :: " + employeeId));

        employee.setLastName(employeeDetails.getLastName());
        employee.setFirstName(employeeDetails.getFirstName());
        final Employee updatedEmployee = employeeRepository.save(employee);
        return ResponseEntity.ok(updatedEmployee);
    }


    @PostMapping("/employee")
    public Employee createEmployee(@RequestBody Employee employee) {

        return this.employeeRepository.save(employee);

    }
    @DeleteMapping("/deleteEmployee/{id}")

    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long Eid)
            throws ResourceNotFound {

        Employee employee = employeeRepository.findById(Eid)
                .orElseThrow(() -> new ResourceNotFound("Asset not found for this id :: " + Eid));

        employeeRepository.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return response;
    }



}
