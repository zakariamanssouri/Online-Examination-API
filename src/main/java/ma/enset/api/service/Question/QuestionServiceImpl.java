package ma.enset.api.service.Question;

import lombok.AllArgsConstructor;
import ma.enset.api.entities.Question;
import ma.enset.api.entities.Test;
import ma.enset.api.repositories.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class QuestionServiceImpl implements QuestionService{
    QuestionRepository questionRepository;
    @Override
    public List<Question> getAllQuestions(Test test) {
        return questionRepository.getQuestionsByTest(test);
    }

    @Override
    public Question getQuestion(Long id) {
        return questionRepository.getById(id);
    }

    @Override
    public Question addNewQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public void deleteQuestion(Long id) {
         questionRepository.deleteById(id);
    }

    @Override
    public Question updateQuestion(Question question, long id) {
           question.setId(id);
            return questionRepository.save(question);
    }
}
