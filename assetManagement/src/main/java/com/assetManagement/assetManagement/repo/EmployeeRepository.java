package com.assetManagement.assetManagement.repo;

import com.assetManagement.assetManagement.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Locale;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
