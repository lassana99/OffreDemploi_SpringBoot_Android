package sn.esmt.emploi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "sn.esmt.emploi")
@EnableAutoConfiguration
public class EmploiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmploiApplication.class, args);
	}

}