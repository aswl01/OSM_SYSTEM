package com.csair.osm_system.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csair.osm_system.domain.OSMRole;
import com.csair.osm_system.repo.OSMRoleRepository;

@Service
public class OSMRoleService {

	@Autowired
	private OSMRoleRepository osmRoleRepository;
	
	public OSMRole addOSMRole(OSMRole role) {
		return osmRoleRepository.save(role);
	}

	public List<OSMRole> findAll() {
		List<OSMRole> roles = new ArrayList<>();
		osmRoleRepository.findAll().forEach(roles::add);
		return roles;
	}

	public OSMRole updateOSMRole(OSMRole role) {
		return osmRoleRepository.save(role);
	}

	public void deleteOSMRole(Long roleId) {
		osmRoleRepository.delete(roleId);
	}
}
