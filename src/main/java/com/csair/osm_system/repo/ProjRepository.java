package com.csair.osm_system.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.csair.osm_system.domain.Proj;

@Repository
public interface ProjRepository extends CrudRepository<Proj, Long> {
	
}
