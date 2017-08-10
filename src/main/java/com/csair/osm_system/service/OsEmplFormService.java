package com.csair.osm_system.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.csair.osm_system.domain.OsEmplForm;
import com.csair.osm_system.domain.Staff;
import com.csair.osm_system.repo.OsEmplFormRepository;

@Service
public class OsEmplFormService {

	@Autowired
	private OsEmplFormRepository osEmplFormRepository;

	public OsEmplForm addOsEmplForm(OsEmplForm osEmplForm) throws Exception {
		Staff current_user = (Staff) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(current_user.getCsStaff().getId() == osEmplForm.getProj().getProjectManager().getId()) {
			return osEmplFormRepository.save(osEmplForm);
		}else {
			throw new Exception("You can only apply for your own project.");
		}
	}

	public List<OsEmplForm> findAll() {
		List<OsEmplForm> osEmplForms = new ArrayList<>();
		osEmplFormRepository.findAll().forEach(osEmplForms::add);
		return osEmplForms;
	}

	public OsEmplForm updateOsEmplForm(OsEmplForm osEmplForm) {
		return osEmplFormRepository.save(osEmplForm);
	}

	public void deleteOsEmplForm(Long osEmplFormId) {
		osEmplFormRepository.delete(osEmplFormId);
	}

	public List<OsEmplForm> findByStaff(long id) {
		return osEmplFormRepository.findByProjProjectManagerStaffId(id);
	}

}
