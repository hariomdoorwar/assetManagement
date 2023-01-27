package com.assetManagement.assetManagement.services;

import com.assetManagement.assetManagement.Exception.ResourceNotFound;
import com.assetManagement.assetManagement.entity.Item;

import java.util.List;


public interface ItemService {
    public List<Item> findAllItem();
    public List<Item> searchItem(String keyword);

    public Item findBookById(Long itemId);

    public void createItem(Item item);

    public void updateItem(Item item);

    public void deleteitem(Long itemId) throws ResourceNotFound;
}
