package org.example.repository;

import org.example.model.FraudCheckHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFraudCheckHistoryRepository extends JpaRepository<FraudCheckHistory,Integer> {
}
