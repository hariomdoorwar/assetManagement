package com.assetManagement.assetManagement.repo;

import com.assetManagement.assetManagement.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category,Long> {
}
