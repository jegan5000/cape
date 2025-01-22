package com.ust.carservices.dto;

import lombok.Data;

@Data
public class InquiryRequestDto {
    private Long userId;
    private Long serviceId;
    private String message;
}