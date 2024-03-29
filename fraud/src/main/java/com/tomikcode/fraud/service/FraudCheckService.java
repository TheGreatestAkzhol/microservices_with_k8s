package com.tomikcode.fraud.service;

import com.tomikcode.fraud.model.FraudCheckHistory;
import com.tomikcode.fraud.repository.FraudCheckHistoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class FraudCheckService {
    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;

    public boolean isFraudulentCustomer(Integer customerId){
            fraudCheckHistoryRepository.save(
                    FraudCheckHistory.builder()
                            .customerId(customerId)
                            .isFraudster(false)
                            .createdAt(LocalDateTime.now())
                            .build());
        return false;
    }
}
