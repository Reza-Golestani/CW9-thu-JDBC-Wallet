package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Wallet {
    private Long id;
    private int userId;
    private double balance;
    private String address;
    private List<Transaction> transactions = new LinkedList<Transaction>();
}
