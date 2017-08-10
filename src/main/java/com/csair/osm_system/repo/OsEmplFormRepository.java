package com.csair.osm_system.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.csair.osm_system.domain.OsEmplForm;

@Repository
public interface OsEmplFormRepository extends CrudRepository<OsEmplForm, Long> {
	
	List<OsEmplForm> findByProjProjectManagerStaffId(long id);
}
