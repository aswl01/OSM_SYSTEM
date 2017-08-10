package com.csair.osm_system.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.csair.osm_system.domain.Attendence;
import com.csair.osm_system.domain.OsStaffState;
import com.csair.osm_system.domain.Staff;
import com.csair.osm_system.dto.PushAttendRecordsDto;
import com.csair.osm_system.repo.AttendenceCrudRepository;
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
	
	@Autowired
	private AttendenceCrudRepository attendenceCrudRepository;
	
	public OsStaffState getStateById(Long id) {
		//根据code从staff表中找staff
		Staff staff = staffRepository.findById(id);
		
		//根据staff.os_id从os_state表中找os_state.fk_os_staff_id = staff.os_id 且 validation为1的state
		OsStaffState state = osStateRepository.findFirstByOsStaffAndValidation(staff.getOsStaff(),true);
		
		return state;
	}
	
	/**
	 * 默认所传入的code为外包人员所有
	 * 即此功能仅能被外包人员使用
	 * @param long1
	 * @param attend
	 */
	public void checkIn(Long id) {
		Attendence attend = new Attendence();
		
		attend.setSignIn(new Date());
		attend.setSignOut(null);

		OsStaffState state = getStateById(id);
		
		//关联到如上state
		attend.setOsStaffState(state);
		
		attendenceCrudRepository.save(attend);
	}
	
//	public void checkOut(String code) {
//		List<OsStaffState> state = getStateByCode(code);
//		
//		Attendence signInAttend = attendenceRepository.findByOsStaffStateAndAuditState(state.get(0),false);
//		signInAttend.setAuditState(true); //本日已签退
//		
//		signInAttend.setSignOut(new Date());
//		attendenceRepository.save(signInAttend);		
//	}
	public void checkOut(Long id) {
		Attendence attend = new Attendence();
		
		attend.setSignIn(null);
		attend.setSignOut(new Date());

		OsStaffState state = getStateById(id);
		
		//关联到如上state
		attend.setOsStaffState(state);
		
		attendenceCrudRepository.save(attend);
	}

	public List<Attendence> findTop10OrderByCreateTimeDesc() {
		// TODO Auto-generated method stub
		return attendenceRepository.findTop10ByCreateTime(Sort.Direction.DESC);
	}

}
