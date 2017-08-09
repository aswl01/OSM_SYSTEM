package com.csair.osm_system.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.csair.osm_system.domain.OSMRole;

@Repository
public interface OSMRoleRepository extends CrudRepository<OSMRole, Long> {

}
