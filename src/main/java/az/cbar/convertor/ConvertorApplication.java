package az.cbar.convertor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ConvertorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConvertorApplication.class, args);
	}
}
