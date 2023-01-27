package com.assetManagement.assetManagement.repo;

import com.assetManagement.assetManagement.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepo extends JpaRepository<Department,Long> {
}
