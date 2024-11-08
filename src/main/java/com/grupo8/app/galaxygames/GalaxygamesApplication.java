package com.grupo8.app.galaxygames;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class GalaxygamesApplication {

	public static void main(String[] args) {
		SpringApplication.run(GalaxygamesApplication.class, args);
	}

}
