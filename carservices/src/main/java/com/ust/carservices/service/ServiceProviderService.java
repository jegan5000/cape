package com.ust.carservices.service;

import com.ust.carservices.model.ServiceProvider;
import com.ust.carservices.repository.ServiceProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceProviderService {

    @Autowired
    private ServiceProviderRepository repository;

    public ServiceProvider createServiceProvider(ServiceProvider serviceProvider) {
        return repository.save(serviceProvider);
    }

    public List<ServiceProvider> getAllServiceProviders() {
        return repository.findAll();
    }

    public ServiceProvider getServiceProviderById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Service Provider not found"));
    }

    public ServiceProvider updateServiceProvider(Long id, ServiceProvider serviceProvider) {
        ServiceProvider existingProvider = getServiceProviderById(id);
        existingProvider.setName(serviceProvider.getName());
        existingProvider.setEmail(serviceProvider.getEmail());
        existingProvider.setPhone(serviceProvider.getPhone());
        existingProvider.setAddress(serviceProvider.getAddress());
        return repository.save(existingProvider);
    }

    public void deleteServiceProvider(Long id) {
        repository.deleteById(id);
    }
}