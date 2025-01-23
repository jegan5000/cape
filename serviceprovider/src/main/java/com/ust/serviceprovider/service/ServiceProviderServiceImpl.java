package com.ust.serviceprovider.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.ust.serviceprovider.dto.ServiceProviderDto;
import com.ust.serviceprovider.entity.ServiceProvider;
import com.ust.serviceprovider.repository.ServiceProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional
public class ServiceProviderServiceImpl implements ServiceProviderService {
    @Autowired
    private ServiceProviderRepository repository;


    private Cloudinary cloudinary;

    public ServiceProviderServiceImpl (Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }
    @Override
    public ServiceProvider createServiceProvider(ServiceProviderDto dto, MultipartFile file) throws IOException {
        ServiceProvider serviceProvider = new ServiceProvider();

        // Map DTO fields to the entity
        serviceProvider.setName(dto.getName());
        serviceProvider.setMobileNumber(dto.getMobileNumber());
        serviceProvider.setServices(dto.getServices());
        serviceProvider.setPriceDetails(dto.getPriceDetails());
        serviceProvider.setAddress(dto.getAddress());

        if (file != null) {
            Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
            serviceProvider.setImageUrl(uploadResult.get("secure_url").toString());
        }

        // Save and return the entity
        return repository.save(serviceProvider);
    }


////    @Override
//    public ServiceProvider createServiceProvider(ServiceProvider serviceProvider, MultipartFile file) throws IOException {
//        if (file != null) {
//            Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
//            serviceProvider.setImageUrl(uploadResult.get("secure_url").toString());
//        }
//        return ServiceProviderRepository.save(serviceProvider);
//    }
//    @Override
//    public ServiceProvider createServiceProvider(ServiceProviderDto dto, MultipartFile file) throws IOException {
//        if (file != null) {
//            Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
//            dto.setImageUrl(uploadResult.get("secure_url").toString());
//        }
//        return ServiceProviderRepository.save(dto);
//    }
//    @Override
//    public ServiceProvider createServiceProvider(ServiceProviderDto dto) {
//        ServiceProvider serviceProvider = new ServiceProvider();
//        serviceProvider.setName(dto.getName());
//        serviceProvider.setMobileNumber(dto.getMobileNumber());
//        serviceProvider.setServices(dto.getServices());
//        serviceProvider.setPriceDetails(dto.getPriceDetails());
//        serviceProvider.setAddress(dto.getAddress());
//        serviceProvider.setImageUrl(dto.getImageUrl());
//        return repository.save(serviceProvider);
//    }

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
