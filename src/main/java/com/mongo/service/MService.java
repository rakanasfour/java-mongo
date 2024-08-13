package com.mongo.service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongo.model.Item;
import com.mongo.repositroy.MRepository;

@Service
public class MService {
	
	
	@Autowired
    private MRepository repo;

    public List<Item> getAllItems() {
        return repo.findAll();
    }

    public Optional<Item> getItemById(ObjectId id) {
        return repo.findById(id);
    }

    public Item createItem(Item item) {
        return repo.save(item);
    }

    public Item updateItem(ObjectId id, Item item) {
        Optional<Item> existingItem = repo.findById(id);
        if (existingItem.isPresent()) {
            Item updateItem = existingItem.get();
            updateItem.setName(item.getName());
            updateItem.setPrice(item.getPrice());

  
            return repo.save(updateItem);
        }
        return null;
    }

    public void deleteItem(ObjectId id) {
        repo.deleteById(id);
    }

}
