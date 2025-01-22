package com.ust.carservices.service;


import com.ust.carservices.dto.InquiryRequestDto;
import com.ust.carservices.dto.InquiryResponseDto;
import com.ust.carservices.model.Inquiry;
import com.ust.carservices.repository.InquiryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InquiryService {

    @Autowired
    private InquiryRepository repository;

    public InquiryResponseDto createInquiry(InquiryRequestDto requestDto) {
        Inquiry inquiry = new Inquiry();
        inquiry.setUserId(requestDto.getUserId());
        inquiry.setServiceId(requestDto.getServiceId());
        inquiry.setMessage(requestDto.getMessage());
        Inquiry savedInquiry = repository.save(inquiry);
        return new InquiryResponseDto(savedInquiry);
    }

    public List<InquiryResponseDto> getInquiriesByUser(Long userId) {
        return repository.findByUserId(userId).stream()
                .map(InquiryResponseDto::new)
                .collect(Collectors.toList());
    }

    public List<InquiryResponseDto> getInquiriesByProvider(Long providerId) {
        return repository.findByServiceProviderId(providerId).stream()
                .map(InquiryResponseDto::new)
                .collect(Collectors.toList());
    }

    public InquiryResponseDto updateInquiry(Long id, InquiryRequestDto requestDto) {
        Inquiry inquiry = repository.findById(id).orElseThrow(() -> new RuntimeException("Inquiry not found"));
        inquiry.setMessage(requestDto.getMessage());
        return new InquiryResponseDto(repository.save(inquiry));
    }

    public void deleteInquiry(Long id) {
        repository.deleteById(id);
    }
}
