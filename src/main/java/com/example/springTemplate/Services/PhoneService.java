package com.example.springTemplate.Services;

import com.example.springTemplate.Repository.PhoneRepository;
import com.example.springTemplate.Entities.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhoneService {
    private final PhoneRepository phoneRepository;

    @Autowired
    public PhoneService(PhoneRepository phoneRepository) {
        this.phoneRepository = phoneRepository;
    }

    public Phone savePhone(Phone phone) {
        return phoneRepository.save(phone);
    }

    public Optional<Phone> getPhoneById(Long id) {
        return phoneRepository.findById(id);
    }

    public List<Phone> getAllPhones() {
        return phoneRepository.findAll();
    }

    public List<Phone> searchPhonesByModelName(String modelName) {
        return phoneRepository.findByModelNameContainingIgnoreCase(modelName);
    }

    public void deletePhone(Phone phone) {
        phoneRepository.delete(phone);
    }
}