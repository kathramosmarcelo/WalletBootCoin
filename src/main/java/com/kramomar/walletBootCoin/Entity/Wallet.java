package com.kramomar.walletBootCoin.Entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("Wallet")
public class Wallet implements Serializable {
    @Id
    private String id;
    private double amount;
    private String numberPhone; //
    private String document; //
    private String email; //
    private String account;
}