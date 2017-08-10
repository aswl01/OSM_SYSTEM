package com.csair.osm_system.repo;

import java.util.List;

import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.repository.Repository;

import com.csair.osm_system.domain.Attendence;
import com.csair.osm_system.domain.OsStaffState;


//"SELECT * FROM os_staff_state s WHERE s.validation = 1 AND s.fk_os_staff_id = :os_id"
//"INSERT INTO dept VALUES(131,1,CONCAT('code',1),NOW(),'hong',0,'hong',NOW(),'運研')"
public interface AttendenceRepository extends Repository<Attendence,Long> {

	Attendence findByOsStaffStateAndAuditState(OsStaffState osStaffState, boolean auditState);

//	List<Attendence> findTop10OrderByCreateTimeDesc();
	List<Attendence> findTop10ByCreateTime(Direction orderby);
}
