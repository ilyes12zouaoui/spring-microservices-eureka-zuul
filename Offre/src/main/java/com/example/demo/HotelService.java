package com.example.demo;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
@Service
public class HotelService {
	@Autowired
	private HotelRepository hotelRepository;
	
	public Hotel addHotel(Hotel hotel) {
		return hotelRepository.save(hotel);
	}
	public Hotel updateHotel(int id, Hotel newHotel) {
		if (hotelRepository.findById(id).isPresent()) {
			Hotel existingHotel= hotelRepository.findById(id).get();
			existingHotel.setName(newHotel.getName());
			existingHotel.setAddress(newHotel.getAddress());
			existingHotel.setPhone(newHotel.getPhone());

			return hotelRepository.save(existingHotel);
		} else
			return null;
	}
	public String deleteHotel(int id) {
		if (hotelRepository.findById(id).isPresent()) {
			hotelRepository.deleteById(id);
			return "hotel supprimé";
		} else
			return "hotel non supprimé";
	}
	 public Page<Hotel> findHotelsByName(String name,Pageable pageable) {

		 Page<Hotel> hotels = hotelRepository.hotelByName(name, pageable);
	        return hotels;
	    }

}
