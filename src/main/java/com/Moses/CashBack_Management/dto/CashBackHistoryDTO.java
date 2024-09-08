package com.Moses.CashBack_Management.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CashBackHistoryDTO {
    private Long id;
    private LocalDateTime date;
    private Long cashRewardTransactionId;
    private BigDecimal amountEarned;
    private String description;
    private Long customerId;

}

