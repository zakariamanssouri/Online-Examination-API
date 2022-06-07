package ma.enset.api.service.Question;

import ma.enset.api.entities.Question;
import ma.enset.api.entities.Test;

import java.util.List;

public interface QuestionService {
    List<Question> getAllQuestions(Test test);
    Question getQuestion(Long id);
    Question addNewQuestion(Question question);
    void deleteQuestion(Long id);
    public Question updateQuestion(Question question, long id);

}
