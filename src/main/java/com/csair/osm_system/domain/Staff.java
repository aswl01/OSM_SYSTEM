package com.csair.osm_system.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import com.csair.osm_system.model.Base;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Staff")
public class Staff extends Base implements Serializable, UserDetails{

	private static final long serialVersionUID = 4063783665155406141L;
	
	@ManyToOne
	@JoinColumn(name = "fk_supplier_id")
	@JsonIgnore
	private Supplier supplier;
	
	@OneToOne
	@JoinColumn(name="fk_os_staff_id")
	@JsonIgnore
	private OsStaff osStaff;

	@OneToOne
	@JoinColumn(name="fk_cs_staff_id")
	@JsonIgnore
	private CsStaff csStaff;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="Responsibility", joinColumns={  
	                @JoinColumn(name="staff_id", referencedColumnName = "id")  
	                }  
	            , inverseJoinColumns={  
	                @JoinColumn(name="osm_role_id", referencedColumnName = "id") 
	                })
	private Set<OSMRole> osmRoles;
	
	private String password;

	public String getUsername() {
		return super.getCode();
	}

	@JsonIgnore
	public String getPassword() {
		return password;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if (osmRoles == null) {
			return null;
		}
		List<String> roleNames = osmRoles.stream().map(OSMRole::getName).collect(Collectors.toList());
		String authorityString = StringUtils.collectionToCommaDelimitedString(roleNames);
		return AuthorityUtils.commaSeparatedStringToAuthorityList(authorityString);
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
