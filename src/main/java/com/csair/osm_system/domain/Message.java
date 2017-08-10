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

@Entity
@Table(name = "Message")
@Getter
@Setter
public class Message extends Base implements Serializable{

	private static final long serialVersionUID = -8829193185156979096L;

	@ManyToOne
	@JoinColumn(name="fk_staff_id")
	private Staff Staff;
	

	@Column(length=255)
	private String content;
	
	private Boolean readed;
	
}
