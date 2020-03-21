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

import com.awg.j20.simpsons.persist.CartoonDatastore;
import com.awg.j20.simpsons.srv.FileLoader;

/**
 * Main application entry point
 */
@SpringBootApplication
public class SimpsonsApplication implements CommandLineRunner {
	private Logger logger = LoggerFactory.getLogger("SimpsonsApplication");
	@Autowired
    private Environment env;
	
	@Autowired
	private FileLoader fileLoader;
	@Autowired
	private CartoonDatastore datastore;

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
		
		//fileLoader.loadCharacters();
		//fileLoader.loadPhrases();
		
		int count = datastore.loadAsBabblers(fileLoader.loadCharacters(), fileLoader.loadPhrases());
		logger.info("Cartoon datastore initialized for : " + count + " babblers.");
	}
}
