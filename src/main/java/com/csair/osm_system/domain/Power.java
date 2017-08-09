package com.csair.osm_system.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.csair.osm_system.model.Base;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
@Entity
@Table(name = "Power")
public class Power extends Base implements Serializable{

	private static final long serialVersionUID = -4527401566562099104L;
	
	private String powerContent;

}