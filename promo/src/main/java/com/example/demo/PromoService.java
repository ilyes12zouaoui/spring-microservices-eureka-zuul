package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class PromoService implements PromoServiceInterface {

	@Autowired
	PromoRepository promoRepository;

	public List<Promo> findAll() {
		List<Promo> result = new ArrayList<Promo>();
		promoRepository.findAll().forEach(result::add);
		return result;
	}

	public List<Promo> findPromosByName(String title) {
		List<Promo> result = new ArrayList<Promo>();
		promoRepository.findPromosByTitle(title).forEach(result::add);
		return result;
	}

	public Optional<Promo> findById(int id) {
		return promoRepository.findById(id);
	}

	public Promo save(Promo stock) {
		return promoRepository.save(stock);
	}

	public Promo Update(Promo newPromo, int id) {
		Promo oldPromo = promoRepository.findById(id).get();
		if (!newPromo.getDescription().isEmpty())
			oldPromo.setDescription(newPromo.getDescription());
		if (!newPromo.getTitle().isEmpty())
			oldPromo.setTitle(newPromo.getTitle());
		
			oldPromo.setPercentage(newPromo.getPercentage());
			oldPromo.setStart(newPromo.getStart());
			oldPromo.setEnd(newPromo.getEnd());
	
		return promoRepository.save(oldPromo);

	}

	public void deleteById(int id) {
		promoRepository.deleteById(id);
	}

}
