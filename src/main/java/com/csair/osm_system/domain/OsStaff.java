package com.csair.osm_system.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.csair.osm_system.model.Base;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "OS_Staff")
public class OsStaff extends Base implements Serializable{

	private static final long serialVersionUID = -568576507162760348L;

	@ManyToOne
	@JoinColumn(name="fk_supplier_id")
	private Supplier supplier;
	
	@Column(length=18)
	private String nationalId;

	private String education;
	
	private Boolean guaranteeLetter;
	
	private Boolean rules;
	
	private Boolean idCopy;
	
	private Boolean ssCertificate;

}
