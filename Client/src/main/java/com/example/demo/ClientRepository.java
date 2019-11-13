package com.example.demo;

import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ClientRepository extends JpaRepository<Client, Integer> {
	@Query("select c from Client c where c.firstName like :fisrtName")
	public Page<Client> clientByName(@Param("fisrtName") String fisrtName, Pageable pageable);

	@Query("select c from Client c where c.address like :address")
	public Page<Client> clientByAddress(@Param("address") String address, Pageable pageable);

}
