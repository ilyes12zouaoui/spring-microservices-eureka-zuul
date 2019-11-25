package com.example.demo;

import java.util.List;
import java.util.Optional;

public interface PromoServiceInterface {
	public List<Promo> findAll();
	public List<Promo> findPromosByName(String title);
	public Optional<Promo> findById(int id);
	public Promo save(Promo stock);
	public Promo Update(Promo newPromo, int id);
	public void deleteById(int id);
}
