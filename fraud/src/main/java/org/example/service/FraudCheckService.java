package org.example.service;

import lombok.AllArgsConstructor;
import org.example.model.FraudCheckHistory;
import org.example.repository.IFraudCheckHistoryRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class FraudCheckService {

    private final IFraudCheckHistoryRepository fraudCheckHistoryRepository;
    public Boolean isFraudulentCustomer(Integer customerId){
        FraudCheckHistory f = FraudCheckHistory.builder().customerId(customerId)
                        .isFraud(false)
                                .createdAt(LocalDateTime.now())
                                        .build();

        fraudCheckHistoryRepository.save(f);
        return false;
    }
}
