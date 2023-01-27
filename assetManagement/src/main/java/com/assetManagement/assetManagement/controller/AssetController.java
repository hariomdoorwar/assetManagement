package com.assetManagement.assetManagement.controller;

import com.assetManagement.assetManagement.Exception.ResourceNotFound;
import com.assetManagement.assetManagement.entity.Item;
import com.assetManagement.assetManagement.repo.AssetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RestController
public class AssetController {
    @Autowired
    private AssetRepo assetRepo;

    @GetMapping("/asset")
    public List<Item> getAllAsset(){

        return this.assetRepo.findAll();
    }

    @GetMapping("/asset/{id}")
    public ResponseEntity<Item> getAssetById(@PathVariable(value = "id") Long assetId)
            throws ResourceNotFound {
        Item item = assetRepo.findById(assetId)
                .orElseThrow(()-> new ResourceNotFound("Asset Not Found For This id ::" + assetId ));
        return ResponseEntity.ok().body(item);
    }
    @PostMapping("/asset")
    public Item createAsset(@RequestBody Item item){

        return this.assetRepo.save(item);
    }
    @DeleteMapping("/asset/{id}")

    public Map<String, Boolean> deleteAsset(@PathVariable(value = "id") Long itemId)
            throws ResourceNotFound {

        Item item = assetRepo.findById(itemId)
                .orElseThrow(() -> new ResourceNotFound("Asset not found for this id :: " + itemId));

        assetRepo.delete(item);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
