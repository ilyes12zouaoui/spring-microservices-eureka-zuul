package com.example.demo;

import java.util.List;

import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;




public interface PromoRepository  extends JpaRepository<Promo, Integer> {
	@Query(value="select * from promo u where u.title LIKE %:title%",nativeQuery=true)
	List<Promo> findPromosByTitle(@Param("title") String name);
	

}
