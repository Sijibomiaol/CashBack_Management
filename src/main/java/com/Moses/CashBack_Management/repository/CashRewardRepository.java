package com.Moses.CashBack_Management.repository;


import com.Moses.CashBack_Management.entity.CashReward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CashRewardRepository extends JpaRepository<CashReward, Long> {

    Optional<CashReward> findByCustomerId(Long CustomerId);


}
