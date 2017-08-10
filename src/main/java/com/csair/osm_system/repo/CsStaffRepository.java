package com.csair.osm_system.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.csair.osm_system.domain.CsStaff;

@Repository
public interface CsStaffRepository extends CrudRepository<CsStaff, Long> {
	
}
