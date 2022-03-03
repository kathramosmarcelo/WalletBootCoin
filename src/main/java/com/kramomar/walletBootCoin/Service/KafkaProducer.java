package com.kramomar.walletBootCoin.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.kramomar.walletBootCoin.Entity.Wallet;
import com.kramomar.walletBootCoin.Utils.Topic;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service
public class KafkaProducer {


	@Autowired
	public  KafkaTemplate<String, Wallet> WalletkafkaTemplate;
	
	public String createWallet( double amount) {
		WalletkafkaTemplate.send(Topic.CREATE_WALLET, new Wallet("WALLET-001",amount,"912117895","88888888","hotmail@hotmail.com","123456-12345-123"));
		return "Connecting Successfully :D";
	    		
	}
	public Wallet publishEventcreateWallet(Wallet wallet){
		WalletkafkaTemplate.send(Topic.CREATE_WALLET,wallet);
	    return wallet;
	}
}
	
	
	