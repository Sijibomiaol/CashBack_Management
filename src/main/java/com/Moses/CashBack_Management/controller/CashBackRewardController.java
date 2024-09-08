package com.Moses.CashBack_Management.controller;

import com.Moses.CashBack_Management.dto.CashBackHistoryDTO;
import com.Moses.CashBack_Management.exception.ErrorMessage;
import com.Moses.CashBack_Management.exception.RewardNotFoundException;
import com.Moses.CashBack_Management.service.CashRewardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/rewards")
public class CashBackRewardController {

    private  final CashRewardService cashRewardService;

    @GetMapping("/balance/{customerId}")
    public ResponseEntity<String> getCashRewardAndCurrentBalance(@PathVariable Long customerId) {
        try {
            String cashBackInfo = cashRewardService.getCashRewardAndCurrentBalanceByCustomerId(customerId);
            return ResponseEntity.ok(cashBackInfo);
        }
        catch (RewardNotFoundException e) {
            ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND, e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/history/{customerId}")
    public ResponseEntity<List<CashBackHistoryDTO>> getCashBackHistoriesByCustomerId(@PathVariable Long customerId) {
        try {
            List<CashBackHistoryDTO> cashBackHistories = cashRewardService.getCashRewardHistoryByCustomerId(customerId);
            return ResponseEntity.ok(cashBackHistories);
        } catch (RewardNotFoundException e) {

            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (Exception e) {

            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    }






