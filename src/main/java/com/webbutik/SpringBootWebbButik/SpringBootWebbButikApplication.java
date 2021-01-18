package com.webbutik.SpringBootWebbButik;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ApplicationContext;



@SpringBootApplication 
@EnableAutoConfiguration
//(exclude = { SecurityAutoConfiguration.class })
public class SpringBootWebbButikApplication {
	 private static final Logger LOGGER = LogManager.getLogger(SpringBootWebbButikApplication.class);


	public static void main(String[] args) {
//		SpringApplication.run(SpringBootWebbButikApplication.class, args);
//	}
			
    ApplicationContext ctx = SpringApplication.run(SpringBootWebbButikApplication.class, args);
    
    LOGGER.info("Info-log message");
    LOGGER.debug("Debug- log message");
    LOGGER.error("Error- log message");

}
}
