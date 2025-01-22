package com.ust.carservices.dto;

import com.ust.carservices.model.Inquiry;
import lombok.Data;

@Data
public class InquiryResponseDto {
    private Long id;
    private Long userId;
    private Long serviceId;
    private String message;

    public InquiryResponseDto(Inquiry inquiry) {
        this.id = inquiry.getId();
        this.userId = inquiry.getUserId();
        this.serviceId = inquiry.getServiceId();
        this.message = inquiry.getMessage();
    }
}