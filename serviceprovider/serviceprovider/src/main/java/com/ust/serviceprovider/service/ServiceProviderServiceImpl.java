package com.ust.serviceprovider.service;

import com.ust.serviceprovider.dto.ServiceProviderDto;
import com.ust.serviceprovider.entity.ServiceProvider;
import com.ust.serviceprovider.repository.ServiceProviderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ServiceProviderServiceImpl implements ServiceProviderService {

    private final ServiceProviderRepository repository;

    public ServiceProviderServiceImpl(ServiceProviderRepository repository) {
        this.repository = repository;
    }

    @Override
    public ServiceProvider createServiceProvider(ServiceProviderDto dto) {
        ServiceProvider serviceProvider = new ServiceProvider();
        serviceProvider.setName(dto.getName());
        serviceProvider.setMobileNumber(dto.getMobileNumber());
        serviceProvider.setServices(dto.getServices());
        serviceProvider.setPriceDetails(dto.getPriceDetails());
        serviceProvider.setAddress(dto.getAddress());
        serviceProvider.setImageUrl(dto.getImageUrl());
        return repository.save(serviceProvider);
    }

    @Override
    public List<ServiceProvider> getAllServiceProviders() {
        return repository.findAll();
    }

    @Override
    public ServiceProvider getServiceProviderById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("ServiceProvider not found"));
    }

    @Override
    public ServiceProvider updateServiceProvider(Long id, ServiceProviderDto dto) {
        ServiceProvider serviceProvider = getServiceProviderById(id);
        serviceProvider.setName(dto.getName());
        serviceProvider.setMobileNumber(dto.getMobileNumber());
        serviceProvider.setServices(dto.getServices());
        serviceProvider.setPriceDetails(dto.getPriceDetails());
        serviceProvider.setAddress(dto.getAddress());
        serviceProvider.setImageUrl(dto.getImageUrl());
        return repository.save(serviceProvider);
    }

    @Override
    public void deleteServiceProvider(Long id) {
        repository.deleteById(id);
    }
}
