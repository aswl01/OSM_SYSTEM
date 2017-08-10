package com.csair.osm_system.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="bid")
public class Bid implements Serializable{

	private static final long serialVersionUID = 3192214657603368017L;

	@Id
	@ManyToOne
	@JoinColumn(name="fk_proj_id")
	private Proj proj;
	
	@Id
	@ManyToOne
	@JoinColumn(name="fk_os_pos_id")
	private OsPos osPos;
	
	@Id
	@ManyToOne
	@JoinColumn(name="fk_supplier_id")
	private Supplier supplier;
	
	@Id
	private String level;
	
	@Id
	private double bidPrice;
	
	private int nrofPeople;

}
