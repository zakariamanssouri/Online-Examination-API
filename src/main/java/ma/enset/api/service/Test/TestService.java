package ma.enset.api.service.Test;

import ma.enset.api.entities.Question;
import ma.enset.api.entities.Test;
import ma.enset.api.entities.User;

import java.util.List;

public interface TestService {
    List<Test> getAll();

    Test addNewTest(Test test);

    Test getTestById(long id);

    Test updateTest(Test test, long id);

    String deleteTestById(long id);

    List<Test> getTestsByKeyword(String keyword);

    List<Question> getTestQuestions(long id);
}
