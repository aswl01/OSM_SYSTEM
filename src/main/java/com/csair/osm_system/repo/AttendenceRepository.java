package com.csair.osm_system.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.csair.osm_system.domain.Attendence;
import com.csair.osm_system.domain.OsStaffState;


//"SELECT * FROM os_staff_state s WHERE s.validation = 1 AND s.fk_os_staff_id = :os_id"
//"INSERT INTO dept VALUES(131,1,CONCAT('code',1),NOW(),'hong',0,'hong',NOW(),'運研')"
@Repository
public interface AttendenceRepository extends CrudRepository<Attendence,Long> {

	Attendence findByOsStaffStateAndAuditState(OsStaffState osStaffState, boolean auditState);

}
