package com.csair.osm_system.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.csair.osm_system.model.Base;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
@Entity
@Table(name = "OS_Staff")
public class OsStaff extends Base implements Serializable{

	private static final long serialVersionUID = -568576507162760348L;

	@ManyToOne
	@JoinColumn(name="fk_supplier_id")
	private Supplier supplier;
	
	@OneToOne
	@JoinColumn(name="fk_staff_id")
	private Staff staff;
	
	@Column(length=18)
	private String nationalId;

	private String education;
	
	private Boolean guaranteeLetter;
	
	private Boolean rules;
	
	private Boolean idCopy;
	
	private Boolean ssCertificate;

}
