package com.kramomar.walletBootCoin.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kramomar.walletBootCoin.Entity.Wallet;
import com.kramomar.walletBootCoin.Repository.WalletRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/WalletBootCoin")
public class WalletController {
	 
	

	private final WalletRepository walletRepository;
	
	@PostMapping
	Mono<Wallet> createWallet(@RequestBody Wallet wallet) {
	return walletRepository.save(wallet);
	}
}
