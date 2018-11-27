package it.nextre.academy.restdemo;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestDemoApplication {

	private static final Logger logger = LogManager.getLogger(RestDemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RestDemoApplication.class, args);
		//logga();
	}


	public static void logga() {
		logger.debug("Debugging log");
		logger.info("Info log");
		logger.warn("Hey, This is a warning!");
		logger.error("Oops! We have an Error. OK");
		logger.fatal("Damn! Fatal error. Please fix me.");
	}
}
