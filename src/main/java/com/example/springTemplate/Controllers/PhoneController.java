package com.example.springTemplate.Controllers;

import com.example.springTemplate.Entities.Phone;
import com.example.springTemplate.Services.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/phones")
public class PhoneController {
    private final PhoneService phoneService;

    @Autowired
    public PhoneController(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    @PostMapping
    public ResponseEntity<Phone> createPhone(@RequestBody Phone phone) {
        Phone savedPhone = phoneService.savePhone(phone);
        return ResponseEntity.ok(savedPhone);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Phone> getPhoneById(@PathVariable Long id) {
        return phoneService.getPhoneById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Phone>> getAllPhones() {
        List<Phone> phones = phoneService.getAllPhones();
        return ResponseEntity.ok(phones);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Phone>> searchPhonesByModelName(@RequestParam String modelName) {
        List<Phone> phones = phoneService.searchPhonesByModelName(modelName);
        return ResponseEntity.ok(phones);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePhone(@PathVariable Long id) {
        phoneService.getPhoneById(id).ifPresent(phoneService::deletePhone);
        return ResponseEntity.noContent().build();
    }
}