package com.example.demo;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="zuul1",url = "localhost:8765")
public interface PromoServiceProxy {

	@GetMapping("/promo-service/promos")
	public List<Promo> retrievePromos();
}
