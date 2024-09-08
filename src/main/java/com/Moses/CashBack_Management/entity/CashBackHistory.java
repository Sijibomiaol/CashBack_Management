package com.Moses.CashBack_Management.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class CashBackHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "transactionId", referencedColumnName = "transactionId")
    private CashReward cashReward;
    private LocalDateTime date;
    private BigDecimal amountEarned;
    private String description;
    @ManyToOne
    @JoinColumn(name = "customerId", referencedColumnName = "id")
    private Customer customer;


    public CashBackHistory(CashReward cashReward, LocalDateTime date, BigDecimal amountEarned, String description, Customer customer) {
        this.cashReward = cashReward;
        this.date = date;
        this.amountEarned = amountEarned;
        this.description = description;
        this.customer = customer;
    }
}