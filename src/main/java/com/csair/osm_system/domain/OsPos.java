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
@Table(name = "OS_Pos")
public class OsPos extends Base implements Serializable{

	private static final long serialVersionUID = 1326352041030208643L;
	
}