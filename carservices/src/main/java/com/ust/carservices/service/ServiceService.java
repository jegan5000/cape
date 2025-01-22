package com.ust.carservices.service;


//import com.ust.carservices.model.Services;
import com.ust.carservices.model.Services;
import com.ust.carservices.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceService {

    @Autowired
    private ServiceRepository repository;

    public Services createService(Services services) {
        return repository.save(services);
    }

    public List<Services> getAllServices() {
        return repository.findAll();
    }

    public Services getServiceById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Service not found"));
    }

    public Services updateService(Long id, Services services) {
        Services existingService = getServiceById(id);
        existingService.setName(services.getName());
        existingService.setDescription(services.getDescription());
        existingService.setPrice(services.getPrice());
        return repository.save(existingService);
    }

    public void deleteService(Long id) {
        repository.deleteById(id);
    }
}
