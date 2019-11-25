package com.example.demo;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="zuul-gateway",url = "localhost:8762")
public interface ClientServiceProxy {

	@GetMapping("/client-service/api/clients")
	public List<Client> retrieveClients();
	
	
}
