package YOUHA.junior;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class KjkmovieApplication {

	public static void main(String[] args) {
		SpringApplication.run(KjkmovieApplication.class, args);
	}

}
