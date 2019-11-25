package com.example.demo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/clients")
public class ClientRestAPI {
	private String title = "Hello, I'm the client Microserviceeeee";

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PromoServiceProxy proxy;

	@Autowired
	private ClientService clientService;

	@RequestMapping("/hello")
	public String sayHello() {
		System.out.println(title);
		return title;
	}

	@GetMapping
	public List<Client> findClients() {
		List<Client> Clients = (List<Client>) clientService.findAll();
		return Clients;
	}

	@GetMapping("/fromPromos")
	public List<Promo> findClientsFromPromos() {
		List<Promo> response = proxy.retrievePromos();
		logger.info("{}", response);
		List<Client> Clients = (List<Client>) clientService.findAll();
		return response;
	}

	@PostMapping
	public ResponseEntity<Client> createCandidat(@RequestBody Client client) {
		return new ResponseEntity<>(clientService.addClient(client), HttpStatus.OK);
	}

	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Client> updateClient(@PathVariable(value = "id") int id, @RequestBody Client client) {
		return new ResponseEntity<>(clientService.updateClient(id, client), HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> deleteClient(@PathVariable(value = "id") int id) {
		return new ResponseEntity<>(clientService.deleteClient(id), HttpStatus.OK);
	}

	@GetMapping(value = "/{address}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Client> findClientByAdress(@PathVariable(value = "address") String address, Pageable pageable) {
		return (clientService.findClientByAddress(address, pageable).getContent());
	}
}
