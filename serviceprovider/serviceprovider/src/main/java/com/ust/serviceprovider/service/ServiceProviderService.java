package com.ust.serviceprovider.service;


import com.ust.serviceprovider.dto.ServiceProviderDto;
import com.ust.serviceprovider.entity.ServiceProvider;
import java.util.List;

public interface ServiceProviderService {
    ServiceProvider createServiceProvider(ServiceProviderDto serviceProviderDto);

    List<ServiceProvider> getAllServiceProviders();

    ServiceProvider getServiceProviderById(Long id);

    ServiceProvider updateServiceProvider(Long id, ServiceProviderDto serviceProviderDto);

    void deleteServiceProvider(Long id);
}

