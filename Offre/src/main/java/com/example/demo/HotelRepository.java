package com.example.demo;


import org.springframework.data.domain.Page;


import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {
	@Query("select h from Hotel h where h.name like :name")
	public Page<Hotel> hotelByName(@Param("name") String name, Pageable pageable);

}
