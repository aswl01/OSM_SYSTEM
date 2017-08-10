package com.csair.osm_system.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.csair.osm_system.model.Base;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Proj")
public class Proj extends Base implements Serializable{

	private static final long serialVersionUID = -41824702861317726L;
	
	/**
	 * code: 采购编码
	 * name: 采购合同名称
	 */
	
	@ManyToOne
	@JoinColumn(name="fk_dept_id")
	private Dept dept;
	
	@ManyToOne
	@JoinColumn(name="fk_project_manager_id")
	@JsonIgnore
	private CsStaff projectManager;
	
	private Boolean termination = false;

}
