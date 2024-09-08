package com.Moses.CashBack_Management.event;

import com.Moses.CashBack_Management.entity.CashBackHistory;
import com.Moses.CashBack_Management.entity.CashReward;
import com.Moses.CashBack_Management.entity.Customer;
import com.Moses.CashBack_Management.repository.CashBackHistoryRepository;
import com.Moses.CashBack_Management.repository.CashRewardRepository;
import com.Moses.CashBack_Management.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Component
public class DataLoader implements CommandLineRunner {
    private final CustomerRepository customerRepository;
    private final CashRewardRepository cashRewardRepository;
    private final CashBackHistoryRepository cashBackHistoryRepository;


    @Override
    public void run(String... args) throws Exception {

        List<Customer> customers = List.of(
                new Customer("Chukwuemeka Obi", "chukwuemeka.obi@example.com", "08012345678"),
                new Customer("Aisha Bello", "aisha.bello@example.com", "07012345678"),
                new Customer("Emeka Nwachukwu", "emeka.nwachukwu@example.com", "09012345678"),
                new Customer("Ngozi Okafor", "ngozi.okafor@example.com", "07023456789"),
                new Customer("Tunde Adeyemi", "tunde.adeyemi@example.com", "08034567890")
        );
        customerRepository.saveAll(customers);

        List<CashReward> cashRewards = List.of(
                new CashReward( BigDecimal.valueOf(100.00), BigDecimal.valueOf(50.00), customerRepository.findByCustomerName("Chukwuemeka Obi")),
                new CashReward( BigDecimal.valueOf(200.00), BigDecimal.valueOf(100.00), customerRepository.findByCustomerName("Aisha Bello")),
                new CashReward( BigDecimal.valueOf(150.00), BigDecimal.valueOf(75.00), customerRepository.findByCustomerName("Emeka Nwachukwu")),
                new CashReward( BigDecimal.valueOf(120.00), BigDecimal.valueOf(60.00), customerRepository.findByCustomerName("Ngozi Okafor")),
                new CashReward( BigDecimal.valueOf(180.00), BigDecimal.valueOf(90.00), customerRepository.findByCustomerName("Tunde Adeyemi"))
        );
                // Save cash rewards to the repository
                cashRewardRepository.saveAll(cashRewards);


        List<CashBackHistory> cashBackHistories = List.of(
                new CashBackHistory(cashRewards.get(0), LocalDateTime.now(), BigDecimal.valueOf(10.00), "Refund for online purchase", customers.get(0)),
                new CashBackHistory(cashRewards.get(1), LocalDateTime.now(), BigDecimal.valueOf(20.00), "Refund for online purchase", customers.get(1)),
                new CashBackHistory(cashRewards.get(2), LocalDateTime.now(), BigDecimal.valueOf(15.00), "Bonus for subscription renewal", customers.get(2)),
                new CashBackHistory(cashRewards.get(3), LocalDateTime.now(), BigDecimal.valueOf(12.00), "Cash back from grocery shopping", customers.get(3)),
                new CashBackHistory(cashRewards.get(4), LocalDateTime.now(), BigDecimal.valueOf(18.00), "Discount on mobile data plan", customers.get(4))
        );

        cashBackHistoryRepository.saveAll(cashBackHistories);








    }
}
