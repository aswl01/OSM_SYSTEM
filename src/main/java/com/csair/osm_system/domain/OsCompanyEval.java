package com.csair.osm_system.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.csair.osm_system.model.Base;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "OS_Company_Eval")
@Data
@EqualsAndHashCode(callSuper=true)
public class OsCompanyEval extends Base implements Serializable{

	private static final long serialVersionUID = -849851520297268720L;	

	@ManyToOne
	@JoinColumn(name="fk_supplier_id")
	private Supplier supplier;
	
	private double overallRating;
	
	private Boolean signed;

}
