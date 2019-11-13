package com.example.demo;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/offres")
public class OffreRestAPI {
	private String title = "Hello, I'm the offre Microserviceeeee";
	@Autowired
	private OffreService offreService;
	
	@RequestMapping("/hello")
	public String sayHello() {
		System.out.println(title);
		return title;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Offre> createCandidat(@RequestBody Offre offre) {
		return new ResponseEntity<>(offreService.addOffre(offre), HttpStatus.OK);
	}
	
	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Offre> updateOffre(@PathVariable(value = "id") int id,
    										@RequestBody Offre offre){
		return new ResponseEntity<>(offreService.updateOffre(id, offre), HttpStatus.OK);
	}
	
	
	@PutMapping(value = "/addHotel/{idO}/{idH}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Offre> addHotelToOffre(@PathVariable(value = "idO") int idO,
    		@PathVariable(value = "idH") int idH){
		return new ResponseEntity<>(offreService.addOffreAndHotel(idO, idH), HttpStatus.CREATED);
	}
	
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteOffre(@PathVariable(value = "id") int id){
		return new ResponseEntity<>(offreService.deleteOffre(id), HttpStatus.OK);
	}
	@GetMapping(value = "/{destination}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Offre> findOffreByDestination(@PathVariable(value = "destination") String destination,Pageable pageable){
		return (offreService.findOffreByDestination(destination,pageable).getContent());
	}
	@RequestMapping("/approvee")
    public String affecterEmployeOffre()
    {
        return offreService.affecterEmployeOff();

    }
}
