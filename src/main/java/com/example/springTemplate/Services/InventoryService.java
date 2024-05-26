package com.example.springTemplate.Services;

import com.example.springTemplate.Entities.Inventory;
import com.example.springTemplate.Repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    @Autowired
    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public Inventory saveInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    public Optional<Inventory> getInventoryById(Long id) {
        return inventoryRepository.findById(id);
    }

    public List<Inventory> getAllInventory() {
        return inventoryRepository.findAll();
    }

    public void deleteInventory(Inventory inventory) {
        inventoryRepository.delete(inventory);
    }
}