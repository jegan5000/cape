package com.ust.serviceprovider.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.ust.serviceprovider.dto.ServiceProviderDto;
import com.ust.serviceprovider.entity.ServiceProvider;
import com.ust.serviceprovider.service.ServiceProviderService;
import com.ust.serviceprovider.service.ServiceProviderServiceImpl;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/service-providers")
public class ServiceProviderController {

    private final ServiceProviderService service;

    public ServiceProviderController(ServiceProviderService service) {
        this.service = service;
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ServiceProvider> createServiceProvider(
            @RequestPart(value = "data") String providerData,
            @RequestPart(value = "image", required = false) MultipartFile file
    ) throws IOException {
        // Convert JSON string to ServiceProviderDto
        ObjectMapper mapper = new ObjectMapper();
        ServiceProviderDto dto = mapper.readValue(providerData, ServiceProviderDto.class);

        // Call the service method to create the ServiceProvider
        ServiceProvider createdProvider = service.createServiceProvider(dto, file);

        // Return the response
        return ResponseEntity.ok(createdProvider);
    }


//    @PostMapping
//    public ResponseEntity<ServiceProvider> createServiceProvider(@RequestBody ServiceProviderDto dto) {
//        return ResponseEntity.ok(service.createServiceProvider(dto));
//    }

    @GetMapping
    public ResponseEntity<List<ServiceProvider>> getAllServiceProviders() {
        return ResponseEntity.ok(service.getAllServiceProviders());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceProvider> getServiceProviderById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getServiceProviderById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServiceProvider> updateServiceProvider(@PathVariable Long id, @RequestBody ServiceProviderDto dto) {
        return ResponseEntity.ok(service.updateServiceProvider(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServiceProvider(@PathVariable Long id) {
        service.deleteServiceProvider(id);
        return ResponseEntity.noContent().build();
    }
}

