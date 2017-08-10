package com.csair.osm_system.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.csair.osm_system.model.Base;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Eval_State")
@Getter
@Setter
public class EvalState extends Base implements Serializable{

	private static final long serialVersionUID = 2616103754959529696L;

	@ManyToOne
	@JoinColumn(name="fk_criteria_id")
	private Criteria criteria;
	
	@ManyToOne
	@JoinColumn(name="fk_os_company_eval_id")
	private OsCompanyEval osCompanyEval;
	
	@ManyToOne
	@JoinColumn(name="fk_os_staff_eval_id")
	private OsStaffEval osStaffEval;
	
	private String rating;

}
