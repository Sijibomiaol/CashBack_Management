package com.Moses.CashBack_Management.repository;


import com.Moses.CashBack_Management.dto.CashBackHistoryDTO;
import com.Moses.CashBack_Management.entity.CashBackHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CashBackHistoryRepository extends JpaRepository<CashBackHistory, Long> {
    List<CashBackHistory> getCashBackHistoriesByCustomerId(Long customerId);


}
