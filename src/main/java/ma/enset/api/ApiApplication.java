package ma.enset.api;

import ma.enset.api.entities.User;
import ma.enset.api.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}
	/*
	@Bean
	CommandLineRunner commandLineRunner(UserRepository userRepository) {
		return args -> {
			for (int i = 0; i < 10; i++) {
				userRepository.save(new User(null, "laayouni mouad", "mouad"+i, "aa@gg.com", "123456",null,null));
			}
		};
	}
	 */
	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
}
