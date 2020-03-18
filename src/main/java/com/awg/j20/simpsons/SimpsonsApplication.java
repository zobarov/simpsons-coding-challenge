package com.awg.j20.simpsons;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.core.env.Environment;

/**
 * Main application entry point
 */
@SpringBootApplication
public class SimpsonsApplication implements CommandLineRunner {
	private Logger logger = LoggerFactory.getLogger("SimpsonsApplication");
	@Autowired
    private Environment env;

	public static void main(String[] args) {
		new SpringApplicationBuilder(SimpsonsApplication.class)
					.web(WebApplicationType.SERVLET)
					.run(args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<String> arguments = Arrays.asList(args);
		logger.info("Starting SimpsonsApplication with parameters: " + arguments);
		
		logger.info("Active Mode: " + env.getProperty("spring.application.name"));		
		logger.info("Active Profiles: " + Arrays.toString(env.getActiveProfiles()));
	}
}
