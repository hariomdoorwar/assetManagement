package com.assetManagement.assetManagement.services;

import com.assetManagement.assetManagement.Exception.ResourceNotFound;
import com.assetManagement.assetManagement.entity.Employee;
import com.assetManagement.assetManagement.repo.EmployeeRepository;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

   @Autowired
   private EmployeeRepository employeeRepository;

   public EmployeeServiceImpl(EmployeeRepository employeeRepository){
       this.employeeRepository = employeeRepository;
   }
    @Override
    public List<Employee> getAllEmployees() {

       return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long Eid) {
        Optional<Employee> optional = employeeRepository.findById(Eid);
        Employee employee = null;
        if (optional.isPresent()) {
            employee = optional.get();
        } else {
            throw new RuntimeException(" Employee not found for id :: " + Eid);
        }
        return employee;
    }

    @Override
    public void createEmployee(Employee employee) {
            employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployeeById(long Eid) throws ResourceNotFound {

        final Employee employee = employeeRepository.findById(Eid)
                .orElseThrow(() -> new ResourceNotFound(String.format("Author not found with ID %d", Eid)));

        employeeRepository.deleteById(Eid);
    }

    @Override
    public void updateEmployee(Employee employee) {
            employeeRepository.save(employee);
    }
}
