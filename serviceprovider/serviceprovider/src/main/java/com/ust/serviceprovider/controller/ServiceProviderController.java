package com.ust.serviceprovider.controller;


import com.ust.serviceprovider.dto.ServiceProviderDto;
import com.ust.serviceprovider.entity.ServiceProvider;
import com.ust.serviceprovider.service.ServiceProviderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service-providers")
public class ServiceProviderController {

    private final ServiceProviderService service;

    public ServiceProviderController(ServiceProviderService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ServiceProvider> createServiceProvider(@RequestBody ServiceProviderDto dto) {
        return ResponseEntity.ok(service.createServiceProvider(dto));
    }

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

