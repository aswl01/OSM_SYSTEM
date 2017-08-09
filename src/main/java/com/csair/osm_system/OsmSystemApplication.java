package com.csair.osm_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class OsmSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(OsmSystemApplication.class, args);
	}
}
