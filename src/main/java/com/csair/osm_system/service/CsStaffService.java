package com.csair.osm_system.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csair.osm_system.domain.CsStaff;
import com.csair.osm_system.repo.CsStaffRepository;

@Service
public class CsStaffService {

	@Autowired
	private CsStaffRepository csStaffRepository;
	
	public CsStaff addCsStaff(CsStaff csStaff) {
		return csStaffRepository.save(csStaff);
	}

	public List<CsStaff> findAll() {
		List<CsStaff> csStaffs = new ArrayList<>();
		csStaffRepository.findAll().forEach(csStaffs::add);
		return csStaffs;
	}

	public CsStaff updateCsStaff(CsStaff csStaff) {
		return csStaffRepository.save(csStaff);
	}

	public void deleteCsStaff(Long csStaffId) {
		csStaffRepository.delete(csStaffId);
	}
}
