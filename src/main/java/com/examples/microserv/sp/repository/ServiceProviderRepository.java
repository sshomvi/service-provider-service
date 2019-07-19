package com.examples.microserv.sp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.examples.microserv.sp.model.ServiceProvider;

@Repository
public interface ServiceProviderRepository extends JpaRepository<ServiceProvider,Long> {

	@Query("select s from ServiceProvider s where s.spCode = :spCode")
	public ServiceProvider findBySpCode(@Param("spCode") String spCode);

}
