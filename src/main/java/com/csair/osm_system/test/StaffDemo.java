package com.csair.osm_system.test;


import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.csair.osm_system.OsmSystemApplication;
import com.csair.osm_system.domain.OSMRole;
import com.csair.osm_system.domain.Staff;
import com.csair.osm_system.service.OSMRoleService;
import com.csair.osm_system.service.StaffService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=OsmSystemApplication.class)
@WebAppConfiguration
public class StaffDemo {
	
	@Before
	public void setUser() {
		Staff staff = new Staff();
		staff.setId(123);
		Authentication auth = new Authentication() {
			
			private static final long serialVersionUID = 2511827780037661844L;
			@Override
			public String getName() {
				return null;
			}
			@Override
			public void setAuthenticated(boolean arg0) throws IllegalArgumentException {
			}
			@Override
			public boolean isAuthenticated() {
				return false;
			}
			@Override
			public Object getPrincipal() {
				return staff;
			}
			@Override
			public Object getDetails() {
				// TODO Auto-generated method stub
				return null;
			}
			@Override
			public Object getCredentials() {
				return null;
			}
			@Override
			public Collection<? extends GrantedAuthority> getAuthorities() {
				return null;
			}
		};
		SecurityContextHolder.getContext().setAuthentication(auth);
	}

	@Autowired
	private StaffService staffService;
	
	@Autowired
	private OSMRoleService osmRoleService;
	
	@Test
	public void testAddStaff() {
		Staff staff = new Staff();
		OSMRole osm_role = new OSMRole();
		osm_role.setName("ROLE_ADMIN");
		osmRoleService.addOSMRole(osm_role);
		staff.setCode("123");
		staff.setPassword("csairmind");
		staff.setName("hehe");
		Set<OSMRole> osm_Roles = new HashSet<>();
		osm_Roles.addAll(osmRoleService.findAll());
		staff.setOsmRoles(osm_Roles);
		staffService.addStaff(staff);
	}

	@Test
	public void testFindAll() {
		List<Staff> staffs = staffService.findAll();
		System.out.println(staffs);
	}

	@Test
	public void testUpdateStaff() {
		String code = "123";
		Staff staff = staffService.findByCode(code);
		staff.setName("helloworld");
		staffService.updateStaff(staff);
	}

	@Test
	public void testDeleteStaff() {
		String code = "kkk";
		Staff staff = staffService.findByCode(code);
		staff.setDelFlag(true);
		staffService.updateStaff(staff);
		
	}

}
