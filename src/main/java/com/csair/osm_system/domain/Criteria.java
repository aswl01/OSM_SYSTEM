package com.csair.osm_system.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.csair.osm_system.model.Base;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Entity
@Table(name = "Criteria")
@Data
@EqualsAndHashCode(callSuper=true)
public class Criteria extends Base implements Serializable{

	private static final long serialVersionUID = 4119215772475403046L;
	
	@Column(length=255)
	private String content;

}
