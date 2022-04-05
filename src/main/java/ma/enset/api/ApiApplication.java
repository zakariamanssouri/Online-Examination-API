package ma.enset.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}
/*
	@Bean
	CommandLineRunner commandLineRunner(UserRepository userRepository) {
		return args -> {
			for (int i = 0; i < 100; i++) {
				userRepository.save(new User(null, "zakaria manssouri", "zakaria"+i, "zz@gg.com", "123456"));
			}
		};
	}*/
}
