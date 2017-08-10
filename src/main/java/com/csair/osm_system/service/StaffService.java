package com.csair.osm_system.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.csair.osm_system.domain.Staff;
import com.csair.osm_system.repo.StaffRepository;

@Service
public class StaffService implements UserDetailsService {

	@Autowired
	private StaffRepository staffRepository;

	public Staff addStaff(Staff staff) throws Exception {

		if (staff.getCode() != null && staff.getPassword() != null && staffRepository.findByCode(staff.getCode()) == null) {
			return staffRepository.save(staff);
		} else {
			throw new Exception("UserCode already exists, please try another one.");
		}
	}

	public List<Staff> findAll() {
		List<Staff> staffs = new ArrayList<>();
		staffRepository.findAll().forEach(staffs::add);
		return staffs;
	}

	public Staff updateStaff(Staff staff) {
		try {
			if (staffRepository.findByCode(staff.getCode()) != null) {
				return staffRepository.save(staff);
			} else {
				throw new Exception("UserCode is not exist, please try another one.");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	public void deleteStaff(Long staffId) {
		staffRepository.delete(staffId);
	}

	public Staff findByCode(String code) {
		return staffRepository.findByCode(code);
	}
	
	public Staff findById(long id) {
		return staffRepository.findOne(id);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if (null == username || username.isEmpty()) {
			throw new UsernameNotFoundException("Username cannot be null or empty");
		}
		Staff staff = staffRepository.findByCode(username);
		if (null == staff) {
			throw new UsernameNotFoundException("User [" + username + "] is not found");
		}
		return staff;
	}

}
