package com.ust.serviceprovider.service;


import com.ust.serviceprovider.dto.ServiceProviderDto;
import com.ust.serviceprovider.entity.ServiceProvider;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ServiceProviderService {
    ServiceProvider createServiceProvider(ServiceProviderDto dto, MultipartFile file) throws IOException;

    List<ServiceProvider> getAllServiceProviders();

    ServiceProvider getServiceProviderById(Long id);

    ServiceProvider updateServiceProvider(Long id, ServiceProviderDto serviceProviderDto);

    void deleteServiceProvider(Long id);
}

