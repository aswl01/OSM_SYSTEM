package com.csair.osm_system.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ApiUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	
	private static final ObjectMapper mapper = new ObjectMapper();
	
	private ApiAuthenticationSuccessHandler successHandler = new ApiAuthenticationSuccessHandler();
	
	public ApiUsernamePasswordAuthenticationFilter() {
		super();
		super.setRequiresAuthenticationRequestMatcher(
				new AntPathRequestMatcher("/api/sessions", "POST"));
		super.setContinueChainBeforeSuccessfulAuthentication(true);
		super.setAuthenticationSuccessHandler(successHandler);
	}
	
	@Autowired
	@Override
	public void setAuthenticationManager(AuthenticationManager authenticationManager) {
		super.setAuthenticationManager(authenticationManager);
	}
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request,
			HttpServletResponse response) throws AuthenticationException {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null) {
			return authentication;
		}
		
		if (!request.getMethod().equals("POST")) {
			throw new AuthenticationServiceException(
					"Authentication method not supported: " + request.getMethod());
		}
		
		try {
			JsonNode data = mapper.readTree(request.getReader());

			String username = data.get("account").asText();
			String password = data.get("password").asText();

			if (username == null) {
				username = "";
			}

			if (password == null) {
				password = "";
			}

			username = username.trim();

			UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(
					username, password);

			setDetails(request, authRequest);

			authentication = this.getAuthenticationManager().authenticate(authRequest);
			if (authentication.isAuthenticated()) {
				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
			return authentication;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
