package com.csair.osm_system.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.csair.osm_system.model.Base;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "OSM_Role")
public class OSMRole extends Base implements Serializable{

	private static final long serialVersionUID = 5190063721848145810L;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="Possession", joinColumns={  
	                @JoinColumn(name="osm_role_id", referencedColumnName = "id")  
	                }  
	            , inverseJoinColumns={  
	                @JoinColumn(name="power_id", referencedColumnName = "id") 
	                })
	private Set<Power> powers;

}
