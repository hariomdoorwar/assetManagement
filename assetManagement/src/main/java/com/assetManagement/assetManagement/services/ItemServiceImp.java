package com.assetManagement.assetManagement.services;

import com.assetManagement.assetManagement.Exception.ResourceNotFound;
import com.assetManagement.assetManagement.entity.Item;
import com.assetManagement.assetManagement.repo.AssetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImp implements ItemService {
@Autowired
    private  AssetRepo assetRepo;

    public ItemServiceImp(AssetRepo assetRepo) {

        this.assetRepo = assetRepo;
    }

    @Override
    public List<Item> findAllItem() {
        return assetRepo.findAll();
    }

    @Override
    public List<Item> searchItem(String keyword) {
        return null;
    }

    @Override
    public Item findBookById(Long itemId) {
        try {
            return (Item) assetRepo.findById(itemId)
                    .orElseThrow(() -> new ResourceNotFound(String.format("Book not found with ID %d", itemId)));
        } catch (ResourceNotFound e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createItem(Item item ){
        assetRepo.save (item);
    }

    @Override
    public void updateItem(Item item) {
        
       assetRepo.save(item);
    }

    @Override
    public void deleteitem(Long itemId) throws ResourceNotFound {
        final ItemService itemService = (ItemService) assetRepo.findById(itemId)
                .orElseThrow(() -> new ResourceNotFound(String.format("Book not found with ID %d", itemId)));

        assetRepo.deleteById(itemId);
    }
}
