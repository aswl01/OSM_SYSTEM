package com.csair.osm_system.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.csair.osm_system.model.Base;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Dept")
@Getter
@Setter
public class Dept extends Base implements Serializable{

	private static final long serialVersionUID = -383080803463597851L;
	
}
