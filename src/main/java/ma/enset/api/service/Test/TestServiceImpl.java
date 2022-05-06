package ma.enset.api.service.Test;

import lombok.AllArgsConstructor;
import ma.enset.api.entities.Test;
import ma.enset.api.repositories.TestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TestServiceImpl implements TestService {
    private TestRepository testRepository;

    @Override
    public List<Test> getAll() {
        return testRepository.findAll();
    }

    @Override
    public Test addNewTest(Test test) {
        return testRepository.save(test);
    }

    @Override
    public Test getTestById(long id) {
        return null;
    }

    @Override
    public Test updateTest(Test test, long id) {
        return null;
    }

    @Override
    public String deleteTestById(long id) {
        return null;
    }
}
