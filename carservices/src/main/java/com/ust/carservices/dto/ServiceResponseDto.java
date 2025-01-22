package com.ust.carservices.dto;

import com.ust.carservices.model.Services;
import lombok.Data;

@Data
public class ServiceResponseDto {
    private Long id;
    private String name;
    private String description;
    private Double price;

    public ServiceResponseDto(Services service) {
        this.id = service.getId();
        this.name = service.getName();
        this.description = service.getDescription();
        this.price = service.getPrice();
    }
}