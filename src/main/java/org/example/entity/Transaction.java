package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entity.enumeration.TransactionType;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Transaction {
    private Long id;
    private TransactionType type;
    private LocalDateTime time;
    private double amount;
    //todo: Add feature: send and receive between wallets
}
