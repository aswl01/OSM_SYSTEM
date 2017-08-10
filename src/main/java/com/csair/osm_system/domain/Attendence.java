package com.csair.osm_system.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.csair.osm_system.model.Base;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Attendence")
@Getter
@Setter
public class Attendence extends Base implements Serializable{

	private static final long serialVersionUID = -1757454114524253131L;

	@ManyToOne
	@JoinColumn(name="fk_os_staff_state_id")
	private OsStaffState osStaffState;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date signIn;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date signOut;
}
