package pl.sasieczno.familyLibrary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
@SpringBootApplication
public class FamilyLibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(FamilyLibraryApplication.class, args);
	}

}
