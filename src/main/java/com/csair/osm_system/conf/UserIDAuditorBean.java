package com.csair.osm_system.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import com.csair.osm_system.domain.Staff;

@Configuration
public class UserIDAuditorBean implements AuditorAware<Long> {

	@Override
    public Long getCurrentAuditor() {
        SecurityContext ctx = SecurityContextHolder.getContext();
        if (ctx == null) {
            return null;
        }
        if (ctx.getAuthentication() == null) {
            return null;
        }
        if (ctx.getAuthentication().getPrincipal() == null) {
            return null;
        }
        Object principal = ctx.getAuthentication().getPrincipal();
        if (principal.getClass().isAssignableFrom(Staff.class)) {
            Staff staff = (Staff) principal;
        	return staff.getId();
        } else {
            return null;
        }
    }
}
