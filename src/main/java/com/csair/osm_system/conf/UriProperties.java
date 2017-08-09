package com.csair.osm_system.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "uri")
public class UriProperties {
	
	private String signin;

	public String getSignin() {
		return signin;
	}

	public void setSignin(String signin) {
		this.signin = signin;
	}

}
