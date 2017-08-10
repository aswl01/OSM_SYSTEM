package com.csair.osm_system.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csair.osm_system.domain.Proj;
import com.csair.osm_system.domain.Staff;
import com.csair.osm_system.repo.ProjRepository;
import com.csair.osm_system.repo.StaffRepository;

@Service
public class ProjService {

	@Autowired
	private ProjRepository projRepository;
	
	@Autowired
	private StaffRepository staffRepository;
	
	public Set<Proj> findByStaff(long id){
		Staff staff = staffRepository.findOne(id);
		return staff.getCsStaff().getProjs();
	}
	
	public Proj addProj(Proj proj) {
		return projRepository.save(proj);
	}

	public List<Proj> findAll() {
		List<Proj> projs = new ArrayList<>();
		projRepository.findAll().forEach(projs::add);
		return projs;
	}

	public Proj updateProj(Proj proj) {
		return projRepository.save(proj);
	}

	public void deleteProj(Long projId) {
		projRepository.delete(projId);
	}
}
