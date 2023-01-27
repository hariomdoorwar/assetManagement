package com.assetManagement.assetManagement.services;

import com.assetManagement.assetManagement.Exception.ResourceNotFound;
import com.assetManagement.assetManagement.entity.Employee;

import java.util.List;

public interface EmployeeService {

   public List<Employee> getAllEmployees();
    public Employee getEmployeeById(long Eid);
   public void createEmployee(Employee employee);
    public void deleteEmployeeById(long Eid) throws ResourceNotFound;
    public void updateEmployee(Employee employee);
}
