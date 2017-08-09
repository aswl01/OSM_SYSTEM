package com.csair.osm_system.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.csair.osm_system.domain.OsStaff;

@Repository
public interface OSStaffRepository extends CrudRepository<OsStaff, Long> {
	
	OsStaff findFirstById(Long id);
}
