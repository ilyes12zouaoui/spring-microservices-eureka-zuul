package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/promos")
public class PromoRestAPI {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PromoService promoService;

	@Autowired
	ClientServiceProxy proxy;
	
	@GetMapping
	public ResponseEntity<List<Promo>> findAll(@RequestParam(value = "title", defaultValue = "") String title) {
		
		
		 return  ResponseEntity.ok(promoService.findPromosByName(title));
		
	}
	@GetMapping("/fromClients")
	public ResponseEntity<List<Promo>> findAllFromClients(@RequestParam(value = "title", defaultValue = "") String title) {
		List<Client> response = proxy.retrieveClients();
		logger.info("{}", response);
		
		
		 return  ResponseEntity.ok(promoService.findPromosByName(title));
		
	}

	@PostMapping
	public ResponseEntity create(@RequestBody Promo promo) {
		return ResponseEntity.ok(promoService.save(promo));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Promo> findById(@PathVariable int id) {
		Optional<Promo> stock = promoService.findById(id);
		if (!stock.isPresent()) {
			ResponseEntity.badRequest().build();
		}

		return ResponseEntity.ok(stock.get());
	}

	@PutMapping("/{id}")
	public ResponseEntity<Promo> update(@PathVariable int id, @RequestBody Promo promo) {
		if (!promoService.findById(id).isPresent()) {
			ResponseEntity.badRequest().build();
		}
	
		return ResponseEntity.ok(promoService.Update(promo,id));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable int id) {
		if (!promoService.findById(id).isPresent()) {
			ResponseEntity.badRequest().build();
		}

		promoService.deleteById(id);

		return ResponseEntity.ok().build();
	}
}
