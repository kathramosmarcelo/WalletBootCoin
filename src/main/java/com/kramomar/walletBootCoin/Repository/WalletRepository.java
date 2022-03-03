package com.kramomar.walletBootCoin.Repository;

import org.springframework.data.redis.core.ReactiveHashOperations;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Component;

import com.kramomar.walletBootCoin.Entity.Wallet;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class WalletRepository {

		private final ReactiveRedisOperations<String, Wallet> redisOperations;
		  private final ReactiveHashOperations<String,String, Wallet> hashOperations;

		  public static final String KEY = "Wallet";
		  public WalletRepository(ReactiveRedisOperations<String, Wallet> redisOperations) {
		    this.redisOperations = redisOperations;
		    this.hashOperations = redisOperations.opsForHash();
		  }
		  
		  public Flux<Wallet> findall(){
		    return hashOperations.values(KEY);
		  }
		  
		  
		  public Mono<Wallet> save(Wallet Wallet){
			return hashOperations.put(KEY, Wallet.getId(), Wallet).map(isSaved -> Wallet);
		  }	 
}
