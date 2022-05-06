package ma.enset.api.service.Test;

import ma.enset.api.entities.Test;
import ma.enset.api.entities.User;

import java.util.List;

public interface TestService {
    List<Test> getAll();

    Test addNewTest(Test test);

    Test getTestById(long id);

    Test updateTest(Test test, long id);

    String deleteTestById(long id);
}
