package com.csair.osm_system.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
public abstract class Base {
	@Id
//	@GeneratedValue(generator = "uuid2")
//	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(columnDefinition = "BINARY(16)")
	private long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createTime;
	
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	@Column(nullable=false)
	private Date modifyTime;

	private Boolean delFlag = false;
	
	private String code;
	
	private String name;
	
	private Boolean auditState;
	
	@CreatedBy
	private long creator;
	
	@LastModifiedBy
	private long modifier;

}
