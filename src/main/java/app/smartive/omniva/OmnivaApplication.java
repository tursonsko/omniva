package app.smartive.omniva;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableConfigurationProperties
@SpringBootApplication
@EnableScheduling
public class OmnivaApplication {

	public static void main(String[] args) {
		SpringApplication.run(OmnivaApplication.class, args);
	}
}
