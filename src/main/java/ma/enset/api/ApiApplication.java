package ma.enset.api;

import ma.enset.api.entities.Choice;
import ma.enset.api.entities.Question;
import ma.enset.api.entities.Test;
import ma.enset.api.entities.User;
import ma.enset.api.repositories.ChoiceRepository;
import ma.enset.api.repositories.QuestionRepository;
import ma.enset.api.repositories.TestRepository;
import ma.enset.api.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(UserRepository userRepository, TestRepository testRepository, QuestionRepository questionRepository, ChoiceRepository choiceRepository) {
		return args -> {
			Test test=new Test();
			Question question1=new Question();
			Question question2=new Question();

			User user = new User(null, "mouad laayouni", "mouad", "aa@gg.com", "123456",null,null);
			user.setOwnedTests(Arrays.asList(test));
			userRepository.save(user);

			test.setCode("CODE");
			test.setLink("hhhtttpppp");
			test.setName("flutter QCM");
			test.setOwner(user);

			Choice c1=new Choice(null,"1",false,question1);
			Choice c2=new Choice(null,"2",true,question1);
			Choice c3=new Choice(null,"3",false,question1);
			Choice c4=new Choice(null,"4",false,question1);
			question1.setTest(test);
			question1.setQuestion("1+1");
			question1.setChoices(
					Arrays.asList(
							c1,c2,c3,c4
					)
			);

			question2.setQuestion("2*2");
			question2.setTest(test);
			Choice cc1=new Choice(null,"8",false,question2);
			Choice cc2=new Choice(null,"6",false,question2);
			Choice cc3=new Choice(null,"4",true,question2);
			Choice cc4=new Choice(null,"2",false,question2);
			question2.setChoices(Arrays.asList(
					cc1,cc2,cc3,cc4
			));
			testRepository.save(test);

			questionRepository.save(question1);
			questionRepository.save(question2);
			test.setQuestions(Arrays.asList(question1,question2));

			choiceRepository.save(c1);
			choiceRepository.save(c2);
			choiceRepository.save(c3);
			choiceRepository.save(c4);

			choiceRepository.save(cc1);
			choiceRepository.save(cc2);
			choiceRepository.save(cc3);
			choiceRepository.save(cc4);

		};
	}

}
