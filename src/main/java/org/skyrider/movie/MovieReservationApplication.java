package org.skyrider.movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication(scanBasePackages = { "org.skyrider.movie" })
@EnableJpaAuditing
public class MovieReservationApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieReservationApplication.class, args);
	}

}
