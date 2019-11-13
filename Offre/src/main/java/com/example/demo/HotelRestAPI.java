package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired
;
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
@RequestMapping(value = "/api/hotels")
public class HotelRestAPI {
	private String title = "Hoteeels ";
	@Autowired
	private HotelService hotelService;
	
	@RequestMapping("/hello")
	public String sayHello() {
		System.out.println(title);
		return title;
	}
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
		return new ResponseEntity<>(hotelService.addHotel(hotel), HttpStatus.OK);
	}
	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Hotel> updateHotel(@PathVariable(value = "id") int id,
    										@RequestBody Hotel hotel){
		return new ResponseEntity<>(hotelService.updateHotel(id, hotel), HttpStatus.OK);
	}
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteHotel(@PathVariable(value = "id") int id){
		return new ResponseEntity<>(hotelService.deleteHotel(id), HttpStatus.OK);
	}
	@GetMapping(value = "/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Hotel> findHotelByName(@PathVariable(value = "name") String name,Pageable pageable){
		return (List<Hotel>) (hotelService.findHotelsByName(name, pageable)).getContent();
	}

}
