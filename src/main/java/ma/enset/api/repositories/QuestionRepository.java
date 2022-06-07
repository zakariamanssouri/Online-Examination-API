package ma.enset.api.repositories;

import ma.enset.api.entities.Question;
import ma.enset.api.entities.Test;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> getQuestionsByTest(Test test);
}