package com.csair.osm_system.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.csair.osm_system.domain.Staff;

@Repository
public interface StaffRepository extends CrudRepository<Staff, Long> {
	
	Staff findByCode(String code);

	Staff findById(Long id);
	
}