package com.csair.osm_system.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.csair.osm_system.model.Base;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "CS_Staff")
@Getter
@Setter
public class CsStaff extends Base implements Serializable{

	private static final long serialVersionUID = -6616960647001309907L;
	
	@OneToOne
	@JoinColumn(name="fk_staff_id")
	@JsonIgnore
	private Staff staff;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="CS_Participation", joinColumns={  
	                @JoinColumn(name="cs_staff_id", referencedColumnName = "id")  
	                }  
	            , inverseJoinColumns={  
	                @JoinColumn(name="proj_id", referencedColumnName = "id") 
	                })
	private Set<Proj> projs;

}