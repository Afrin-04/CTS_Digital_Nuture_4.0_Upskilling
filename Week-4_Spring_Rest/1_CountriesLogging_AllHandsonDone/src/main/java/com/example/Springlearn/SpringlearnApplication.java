package com.example.Springlearn;

import com.example.Springlearn.model.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootApplication(scanBasePackages = "com.example.Springlearn")
@EntityScan("com.example.Springlearn.model")
@EnableJpaRepositories("com.example.Springlearn.repository")
public class SpringlearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringlearnApplication.class);

	public static void main(String[] args) {
		LOGGER.info("START");
		SpringApplication.run(SpringlearnApplication.class, args);
		LOGGER.info("END");

		displayDate();
		displayCountry();
		displayCountries();
	}

	public static void displayDate() {
		LOGGER.info("START - displayDate");
		ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
		SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
		try {
			Date date = format.parse("31/12/2018");
			LOGGER.debug("Parsed Date: {}", date);
		} catch (ParseException e) {
			LOGGER.error("Error parsing date", e);
		}
		LOGGER.info("END - displayDate");
	}

	public static void displayCountry() {
		LOGGER.info("START - displayCountry");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country country = context.getBean("country", Country.class);
		LOGGER.debug("Country: {}", country);
		Country anotherCountry = context.getBean("country", Country.class);
		LOGGER.debug("Another Country Instance: {}", anotherCountry);
		LOGGER.info("END - displayCountry");
	}

	public static void displayCountries() {
		LOGGER.info("START - displayCountries");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		List<Country> countryList = (List<Country>) context.getBean("countryList");
		for (Country c : countryList) {
			LOGGER.debug("Country in list: {}", c);
		}
		LOGGER.info("END - displayCountries");
	}
}
