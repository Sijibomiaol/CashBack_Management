package com.Moses.CashBack_Management.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class CashReward {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;


    private BigDecimal totalCashBack;
    private BigDecimal currentBalance;
    @ManyToOne
    @JoinColumn(name="customerId", referencedColumnName = "id")
    private Customer customer;

    public CashReward(BigDecimal totalCashBack, BigDecimal currentBalance, Customer customer) {
        this.totalCashBack = totalCashBack;
        this.currentBalance = currentBalance;
        this.customer = customer;
    }
}
