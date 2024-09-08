package com.Moses.CashBack_Management.service;


import com.Moses.CashBack_Management.dto.CashBackHistoryDTO;
import com.Moses.CashBack_Management.entity.CashBackHistory;
import com.Moses.CashBack_Management.entity.CashReward;
import com.Moses.CashBack_Management.exception.RewardNotFoundException;
import com.Moses.CashBack_Management.repository.CashBackHistoryRepository;
import com.Moses.CashBack_Management.repository.CashRewardRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class CashRewardServiceImpl implements CashRewardService {
    @Autowired
    private CashRewardRepository cashRewardRepository;
    @Autowired
    private CashBackHistoryRepository cashBackHistoryRepository;

    @Override
    public CashReward getCashRewardByCustomerId(Long customerId) {
        return cashRewardRepository.findByCustomerId(customerId).orElseThrow(()->new RewardNotFoundException("No reward found for" +customerId));


    }
    @Override
    public List<CashBackHistoryDTO> getCashRewardHistoryByCustomerId(Long customerId) {
        List<CashBackHistory> cashBackHistories = cashBackHistoryRepository.getCashBackHistoriesByCustomerId(customerId);
        if (cashBackHistories.isEmpty()) {
            throw new RewardNotFoundException("Cashback history not found for customer" +customerId);
        }
        return cashBackHistories.stream().map(history->new CashBackHistoryDTO(
            history.getId(),
            history.getDate(),
            history.getCashReward().getTransactionId(),
            history.getAmountEarned(),
            history.getDescription(),
            history.getCustomer().getId())).collect(Collectors.toList());
    }

    @Override
    public String getCashRewardAndCurrentBalanceByCustomerId(Long CustomerId){
        CashReward cashReward = getCashRewardByCustomerId(CustomerId);

        if (cashReward==null) {
            throw new RewardNotFoundException("No reward found for " +CustomerId);
        }

        if (!CustomerId.equals(cashReward.getCustomer().getId())) {
            return "Invalid Customer Id" + CustomerId;
        }

        Long CustomerID= cashReward.getCustomer().getId();
        BigDecimal currentBalance = cashReward.getCurrentBalance();
        BigDecimal totalCashBack = cashReward.getTotalCashBack();
        String CustomerName = cashReward.getCustomer().getCustomerName();
      return "Hello " + CustomerName + " ID:" + CustomerID +", your current cashback balance is "  + currentBalance +  " and total cash earn is " + totalCashBack + ".";

    }

}
