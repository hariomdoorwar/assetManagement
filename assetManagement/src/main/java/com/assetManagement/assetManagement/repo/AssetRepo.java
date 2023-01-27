package com.assetManagement.assetManagement.repo;

import com.assetManagement.assetManagement.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssetRepo extends JpaRepository<Item,Long> {

}
