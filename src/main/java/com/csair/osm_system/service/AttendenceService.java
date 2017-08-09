package com.csair.osm_system.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csair.osm_system.domain.Attendence;
import com.csair.osm_system.domain.OsStaffState;
import com.csair.osm_system.domain.Staff;
import com.csair.osm_system.repo.AttendenceRepository;
import com.csair.osm_system.repo.OsStaffStateRepository;
import com.csair.osm_system.repo.StaffRepository;

@Service
public class AttendenceService {
	
	@Autowired
	private OsStaffStateRepository osStateRepository;
	
	@Autowired
	private StaffRepository staffRepository;
	
	@Autowired
	private AttendenceRepository attendenceRepository;
	
	public List<OsStaffState> getStateByCode(String code) {
		//根据code从staff表中找staff
		Staff staff = staffRepository.findByCode(code);
		
		//根据staff.os_id从os_state表中找os_state.fk_os_staff_id = staff.os_id 且 validation为1的state
		List<OsStaffState> state = osStateRepository.findByOsStaffAndValidation(staff.getOsStaff(),true);
		
		return state;
	}
	
	/**
	 * 默认所传入的code为外包人员所有
	 * 即此功能仅能被外包人员使用
	 * @param code
	 * @param attend
	 */
	public void signIn(String code, Attendence attend) {

		List<OsStaffState> state = getStateByCode(code);
		//在attendance中插入一条数据，关联到如上state
		attend.setOsStaffState(state.get(0));
		attend.setAuditState(false); //本日尚未签退为false
		//签到
		attend.setSignIn(new Date());
		attend.setSignOut(null);
		attendenceRepository.save(attend);
	}
	
	public void signOut(String code, Attendence attend) {
		List<OsStaffState> state = getStateByCode(code);
		
		Attendence signInAttend = attendenceRepository.findByOsStaffStateAndAuditState(state.get(0),false);
		signInAttend.setAuditState(true); //本日已签退
		
		attend.setSignOut(new Date());
		attendenceRepository.save(attend);
		
	}

}
