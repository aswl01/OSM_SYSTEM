package com.csair.osm_system.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.csair.osm_system.security.ApiLogoutSuccessHandler;
import com.csair.osm_system.security.ApiUsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConf extends WebSecurityConfigurerAdapter {
	
	@Value("${uri.signin}")
	private String uriSignIn;
	
	@Autowired
	private ApiUsernamePasswordAuthenticationFilter apiUsernamePasswordAuthenticationfilter;
	
	@Autowired
	private ApiLogoutSuccessHandler apiLogoutSuccessHandler;
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers(uriSignIn, "/api/time").permitAll()
				.antMatchers("/api/projects").hasRole("PRJ_MGR")
				.antMatchers("/api/staffs", "/api/roles").hasRole("ADMIN")
				.anyRequest().authenticated()
				.and();
		http
			.addFilterAt(
				apiUsernamePasswordAuthenticationfilter,
				UsernamePasswordAuthenticationFilter.class)
			.csrf()
				.disable()
			.rememberMe()
				.alwaysRemember(true);
		http
			.logout()
				.logoutUrl("/api/logout")
				.logoutSuccessHandler(apiLogoutSuccessHandler)
				.invalidateHttpSession(true)
				.deleteCookies("JSESSIONID");
	}

}
