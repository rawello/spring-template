package com.example.springTemplate.Repository;

import com.example.springTemplate.Entities.Inventory;
import com.example.springTemplate.Entities.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    Optional<Inventory> findByPhone(Phone phone);
}