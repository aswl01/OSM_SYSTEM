package com.csair.osm_system.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.csair.osm_system.model.Base;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Supplier")
public class Supplier extends Base implements Serializable{

	private static final long serialVersionUID = 2593810302591343797L;
	
}
