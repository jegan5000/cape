package com.ust.carservices.controller;


import com.ust.carservices.dto.InquiryRequestDto;
import com.ust.carservices.dto.InquiryResponseDto;
import com.ust.carservices.service.InquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inquiries")
public class InquiryController {

    @Autowired
    private InquiryService inquiryService;

    @PostMapping
    public ResponseEntity<InquiryResponseDto> createInquiry(@RequestBody InquiryRequestDto inquiryRequest) {
        return ResponseEntity.ok(inquiryService.createInquiry(inquiryRequest));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<InquiryResponseDto>> getInquiriesByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(inquiryService.getInquiriesByUser(userId));
    }

    @GetMapping("/provider/{providerId}")
    public ResponseEntity<List<InquiryResponseDto>> getInquiriesByProvider(@PathVariable Long providerId) {
        return ResponseEntity.ok(inquiryService.getInquiriesByProvider(providerId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<InquiryResponseDto> updateInquiry(@PathVariable Long id, @RequestBody InquiryRequestDto inquiryRequest) {
        return ResponseEntity.ok(inquiryService.updateInquiry(id, inquiryRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInquiry(@PathVariable Long id) {
        inquiryService.deleteInquiry(id);
        return ResponseEntity.noContent().build();
    }
}