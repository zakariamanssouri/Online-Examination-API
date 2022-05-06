package ma.enset.api.service.Test;

import lombok.AllArgsConstructor;
import ma.enset.api.Exceptions.Tests.TestAlreadyExistException;
import ma.enset.api.Exceptions.Tests.TestNotFoundException;
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
        if(testRepository.findByCode(test.getCode())!=null) {
            try {
                throw new  TestAlreadyExistException();
            } catch (TestAlreadyExistException e) {
                e.printStackTrace();
            }
        }
        return testRepository.save(test);
    }

    @Override
    public Test getTestById(long id) {
        if (testRepository.findById(id) == null) {
            throw new TestNotFoundException();
        }
        return testRepository.findById(id);
    }

    @Override
    public Test updateTest(Test test, long id) {
        test.setId(id);
        return testRepository.save(test);
    }

    @Override
    public String deleteTestById(long id) {
        if (testRepository.findById(id) == null) {
            throw new TestNotFoundException();
        }
        else  {
            testRepository.deleteById(id);
            return "success";
        }

    }
}
