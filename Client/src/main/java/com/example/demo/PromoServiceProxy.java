package com.example.demo;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "zuul-gateway", url = "localhost:8762")
public interface PromoServiceProxy {

	@GetMapping("/promo-service/promos")
	public List<Promo> retrievePromos();
}
