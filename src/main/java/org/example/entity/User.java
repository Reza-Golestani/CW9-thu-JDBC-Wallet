package org.example.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class User {
    private Long id;
    private String username;
    private String password;
    private List<Wallet> wallets = new ArrayList<Wallet>(); //todo: ?: آیا این اشتباهه؟ اضافیه؟
}
