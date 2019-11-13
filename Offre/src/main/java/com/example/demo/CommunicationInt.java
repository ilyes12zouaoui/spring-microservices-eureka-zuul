package com.example.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="HumanRessource-service")
public interface CommunicationInt {
	@GetMapping("/approve")
	public String affecterEmployeOffre();

}
