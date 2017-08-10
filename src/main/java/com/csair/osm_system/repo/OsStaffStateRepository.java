package com.csair.osm_system.repo;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.csair.osm_system.domain.OsStaff;
import com.csair.osm_system.domain.OsStaffState;

public interface OsStaffStateRepository extends Repository<OsStaffState, Long> {

	List<OsStaffState> findByOsStaffAndValidation(OsStaff osStaff, Boolean validate);

	OsStaffState findFirstByOsStaffAndValidation(OsStaff osStaff, boolean b);

}
