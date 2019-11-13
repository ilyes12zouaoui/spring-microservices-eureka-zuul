package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
	@Autowired
	private ClientRepository clientRepository;

	public List<Client> findAll() {
		List<Client> clients = (List<Client>) clientRepository.findAll();
		return clients;
	}

	public Client addClient(Client client) {
		return clientRepository.save(client);
	}

	public Client updateClient(int id, Client newClient) {
		if (clientRepository.findById(id).isPresent()) {
			Client existingClient = clientRepository.findById(id).get();
			existingClient.setFirstName(newClient.getFirstName());
			existingClient.setLastName(newClient.getLastName());
			existingClient.setAddress(newClient.getAddress());
			existingClient.setBirthDate(newClient.getBirthDate());
			existingClient.setEmail(newClient.getEmail());
			existingClient.setPassword(newClient.getPassword());
			existingClient.setPhoto(newClient.getPhoto());

			return clientRepository.save(existingClient);
		} else
			return null;
	}

	public String deleteClient(int id) {
		if (clientRepository.findById(id).isPresent()) {
			clientRepository.deleteById(id);
			return "client supprimé";
		} else
			return "client non supprimé";
	}

	public Page<Client> findClientByAddress(String address, Pageable pageable) {

		Page<Client> clients = clientRepository.clientByAddress(address, pageable);
		return clients;
	}
}
