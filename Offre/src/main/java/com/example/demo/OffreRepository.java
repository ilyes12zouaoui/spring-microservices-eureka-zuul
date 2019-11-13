package com.example.demo;

import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface OffreRepository  extends JpaRepository<Offre, Integer> {
	@Query("select o from Offre o where o.title like :title")
	public Page<Offre> offreByTitle(@Param("title") String title, Pageable pageable);
	
	@Query("select o from Offre o where o.destination like :destination")
	public Page<Offre> offreByDestination(@Param("destination") String destination, Pageable pageable);

}
