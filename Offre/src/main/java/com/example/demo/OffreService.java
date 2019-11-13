package com.example.demo;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
@Service
public class OffreService {
	@Autowired
	private OffreRepository  offreRepository;

	private CommunicationInt com;
	
	@Autowired
	private HotelRepository hotelRepo;
	
	public Offre addOffre(Offre offre) {
		return offreRepository.save(offre);
	}
	public  Offre addOffreAndHotel(int idO,int idH) {
		Offre o =offreRepository.getOne(idO);
		Hotel h=hotelRepo.getOne(idH);
		o.getHotels().add(h);
		h.getOffre().add(o);
		hotelRepo.save(h);
		offreRepository.save(o);
		return o;
	}
	
	public Offre updateOffre(int id, Offre newOffre) {
		if (offreRepository.findById(id).isPresent()) {
			Offre existingOffre = offreRepository.findById(id).get();
			existingOffre.setTitle(newOffre.getTitle());
			existingOffre.setDestination(newOffre.getDestination());
			existingOffre.setNbPlaces(newOffre.getNbPlaces());

			return offreRepository.save(existingOffre);
		} else
			return null;
	}
	public String deleteOffre(int id) {
		if (offreRepository.findById(id).isPresent()) {
			offreRepository.deleteById(id);
			return "offre supprimé";
		} else
			return "offre non supprimé";
	}
	
	 public Page<Offre> findOffreByDestination(String name,Pageable pageable) {

		 Page<Offre> offres =  offreRepository.offreByDestination(name,pageable);
	        return offres;
	    }
	 public String affecterEmployeOff() {
			return com.affecterEmployeOffre();
					}
}
